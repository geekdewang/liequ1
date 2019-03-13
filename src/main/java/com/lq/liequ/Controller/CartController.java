package com.lq.liequ.Controller;

import com.lq.liequ.common.vo.ResultVo;
import com.lq.liequ.pojo.Cart;
import com.lq.liequ.service.CartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Api(value = "购物车",tags = "购物车")
public class CartController {

    @Autowired
    private CartService cartService;

    @ApiOperation(value = "购物车的添加",notes = "把名字和价钱传递过来添加")
    @PostMapping("cartadd")
    public ResultVo add(Cart cart) {
        return cartService.add(cart);
    }

    @ApiOperation(value = "购物车的展示")
    @GetMapping("cartlist")
    public ResultVo cartlist() {
        return cartService.cartlist();
    }
}

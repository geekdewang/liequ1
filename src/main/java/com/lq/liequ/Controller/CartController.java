package com.lq.liequ.Controller;

import com.lq.liequ.common.vo.ResultVo;
import com.lq.liequ.pojo.Cart;
import com.lq.liequ.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping("cartadd")
    public ResultVo add(Cart cart) {

        return cartService.add(cart);
    }
}

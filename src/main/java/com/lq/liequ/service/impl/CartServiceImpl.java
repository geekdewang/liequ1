package com.lq.liequ.service.impl;

import com.lq.liequ.common.utils.ResultUtil;
import com.lq.liequ.common.vo.ResultVo;
import com.lq.liequ.dao.CartMapper;
import com.lq.liequ.pojo.Cart;
import com.lq.liequ.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Override
    public ResultVo add(Cart cart) {

        ResultVo resultVo = new ResultVo();
        try {
            cartMapper.insertSelective(cart);
            resultVo = ResultUtil.exec( true, "OK", null);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo = ResultUtil.exec( false, "error", e.getMessage());
        }

        return resultVo;
    }

    @Override
    public ResultVo cartlist() {
        ResultVo resultVo = new ResultVo();
        try {
           List<Cart> list = cartMapper.findAll();
            resultVo = ResultUtil.exec( true, "OK", list);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo = ResultUtil.exec( false, "error", e.getMessage());
        }

        return resultVo;
    }
}

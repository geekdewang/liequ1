package com.lq.liequ.service.impl;

import com.lq.liequ.common.utils.ResultUtil;
import com.lq.liequ.common.vo.ResultVo;
import com.lq.liequ.dao.CartMapper;
import com.lq.liequ.pojo.Cart;
import com.lq.liequ.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Override
    public ResultVo add(Cart cart) {

        return ResultUtil.exec(cartMapper.insertSelective(cart) > 0, "OK", null);
    }
}

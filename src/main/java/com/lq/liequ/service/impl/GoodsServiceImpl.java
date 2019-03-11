package com.lq.liequ.service.impl;

import com.lq.liequ.dao.GoodsMapper;
import com.lq.liequ.pojo.Goods;
import com.lq.liequ.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    // 查询全部
    @Override
    public List<Goods> queryAll() {

        return goodsMapper.slelectAll();
    }
}

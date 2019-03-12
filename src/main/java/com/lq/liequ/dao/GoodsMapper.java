package com.lq.liequ.dao;

import com.lq.liequ.pojo.Goods;

import java.util.List;

public interface GoodsMapper {
    int deleteByPrimaryKey(Integer gid);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectById(Integer gid);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    // 查询全部商品
    List<Goods> slelectAll();
}
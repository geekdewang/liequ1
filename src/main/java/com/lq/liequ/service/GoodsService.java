package com.lq.liequ.service;

import com.lq.liequ.common.vo.ResultVo;
import com.lq.liequ.pojo.Goods;

import java.util.List;

public interface GoodsService {

    // 查询全部
    ResultVo queryAll();
    //根据mid查询商品列表
    ResultVo selectByMid(int mid);

    // 根据商品id展示商品详情
    ResultVo queryGoodsId(Integer gid);

    //通过名字模糊查询
    ResultVo findByName(String gname);
}

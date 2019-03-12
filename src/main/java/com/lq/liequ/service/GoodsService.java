package com.lq.liequ.service;

import com.lq.liequ.common.vo.ResultVo;
import com.lq.liequ.pojo.Goods;
import org.w3c.dom.ls.LSInput;

import java.util.List;

public interface GoodsService {

    // 查询全部
    ResultVo queryAll();
    //根据mid查询商品列表
    ResultVo selectByMid(int mid);
}

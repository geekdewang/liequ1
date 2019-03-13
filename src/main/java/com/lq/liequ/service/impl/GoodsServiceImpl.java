package com.lq.liequ.service.impl;

import com.lq.liequ.common.utils.ResultUtil;
import com.lq.liequ.common.vo.ResultVo;
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
    public ResultVo queryAll() {


        ResultVo resultVo = new ResultVo();

        try {
            List<Goods> list = goodsMapper.slelectAll();
            if (list != null) {
                resultVo = ResultUtil.exec(true,"OK", list);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultVo = ResultUtil.exec(true, "ERROR", e.getMessage());
        }


        return resultVo;
    }

    @Override
    public ResultVo selectByMid(int mid) {
        ResultVo resultVo = new ResultVo();

        try {
            List<Goods> list = goodsMapper.selectByMId(mid);
            resultVo = ResultUtil.exec(true,"OK",list);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo = ResultUtil.exec(false,"error",e.getMessage());
        }

        return resultVo;
    }
    @Override
    public ResultVo queryGoodsId(Integer gid) {

        ResultVo resultVo = new ResultVo();

        try {
            Goods list = goodsMapper.slelectById(gid);
            if (list != null)
                resultVo = ResultUtil.exec(true, "OK", list);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo = ResultUtil.exec(true, "ERROR", e.getMessage());
        }

        return resultVo;
    }

    @Override
    public ResultVo findByName(String gname) {
        ResultVo resultVo = new ResultVo();

        try {
            //通过商品名字模糊查询
            List<Goods> list = goodsMapper.findByName(gname);
            if (list != null)
                resultVo = ResultUtil.exec(true, "OK", list);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo = ResultUtil.exec(true, "ERROR", e.getMessage());
        }

        return resultVo;
    }

}


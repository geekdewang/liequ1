package com.lq.liequ.Controller;

import com.lq.liequ.common.utils.ResultUtil;
import com.lq.liequ.common.vo.ResultVo;
import com.lq.liequ.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("goodsAll")
    public ResultVo queryAll() {

        return goodsService.queryAll();
    }

    @RequestMapping("goodsByMid")
    public ResultVo queryByMid(int mid) {

        return goodsService.selectByMid(mid);
    }

    @RequestMapping("goodsIdAll")
    public ResultVo queryIdAll(Integer gid) {

        return goodsService.queryGoodsId(gid);
    }
}

package com.lq.liequ.Controller;

import com.lq.liequ.common.utils.ResultUtil;
import com.lq.liequ.common.vo.ResultVo;
import com.lq.liequ.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Api(value = "商品展示",tags = "商品列表，商品详情")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    //商品全部展示
    @ApiOperation(value = "商品的全部展示")
    @GetMapping("goodsAll")
    public ResultVo queryAll() {

        return goodsService.queryAll();
    }

    //通过二级菜单显示商品列表
    @ApiOperation(value = "商品列表",notes = "通过mid商品列表展示")
    @PostMapping("goodsByMid")
    public ResultVo queryByMid(int mid) {

        return goodsService.selectByMid(mid);
    }

    //商品详情
    @ApiOperation(value = "商品详情",notes = "通过商品gid展示详情")
    @PostMapping("goodsIdAll")
    public ResultVo queryIdAll(Integer gid) {

        return goodsService.queryGoodsId(gid);
    }

    //通过名字模糊查询商品
    @ApiOperation(value = "搜索功能",notes = "通过名字模糊查询")
    @PostMapping("goodsByName")
    public ResultVo queryByName(String gname) {

        return goodsService.findByName(gname);
    }

}

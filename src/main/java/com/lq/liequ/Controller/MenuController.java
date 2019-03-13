package com.lq.liequ.Controller;

import com.lq.liequ.common.vo.ResultVo;
import com.lq.liequ.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Api(value = "菜单的展示",tags = "一级菜单和二级菜单的展示")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @ApiOperation(value = "菜单展示")
    @GetMapping("menulist")
    public ResultVo menuList() {
        return menuService.queryMenu();
    }
}

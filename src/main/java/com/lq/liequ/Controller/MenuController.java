package com.lq.liequ.Controller;

import com.lq.liequ.common.vo.ResultVo;
import com.lq.liequ.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("menulist")
    public ResultVo menuList() {
        return menuService.queryMenu();
    }
}

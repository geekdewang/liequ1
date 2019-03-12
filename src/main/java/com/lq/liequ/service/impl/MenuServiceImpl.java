package com.lq.liequ.service.impl;

import com.lq.liequ.common.utils.ResultUtil;
import com.lq.liequ.common.vo.MenuVo;
import com.lq.liequ.common.vo.ResultVo;
import com.lq.liequ.dao.MenuMapper;
import com.lq.liequ.pojo.Menu;
import com.lq.liequ.service.MenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public ResultVo queryMenu() {

        ResultVo resultVo = new ResultVo();
        try {
            List<Menu> list = menuMapper.findAll();
            List<MenuVo> menus = new ArrayList<>();
            for(Menu p:list){
                if (p.getMid() == 1) {
                    MenuVo menuVo = new MenuVo();
                    BeanUtils.copyProperties(p, menuVo);
                    menuVo.setChildenMenu(new ArrayList<>());
                    menus.add(menuVo);
                }
            }
            resultVo = ResultUtil.exec(true,"Ok",list);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo = ResultUtil.exec(false,"error",e.getMessage());
        }


        return resultVo;
    }
}

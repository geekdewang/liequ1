package com.lq.liequ.service.impl;

import com.lq.liequ.common.utils.ResultUtil;
import com.lq.liequ.common.vo.MenuVo;
import com.lq.liequ.common.vo.ResultVo;
import com.lq.liequ.dao.MenuMapper;
import com.lq.liequ.pojo.Menu;
import com.lq.liequ.service.MenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
                if (p.getLevel() == 1) {
                    MenuVo menuVo = new MenuVo();
                    BeanUtils.copyProperties(p, menuVo);
                    menuVo.setChildenMenu(new ArrayList<>());
                    menus.add(menuVo);
                } else if (p.getLevel() == 2) {
                    //二级菜单
                    MenuVo menuVoParent = getParent(p.getMparentid(),menus);
                    if (menuVoParent != null) {
                        //找到了对应的一级菜单
                        MenuVo childenMenu = new MenuVo();
                        BeanUtils.copyProperties(p,childenMenu);
                        menuVoParent.getChildenMenu().add(childenMenu);
                    }
                }
            }
            resultVo = ResultUtil.exec(true,"Ok",menus);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo = ResultUtil.exec(false,"error",e.getMessage());
        }


        return resultVo;
    }

    private MenuVo getParent(int id,List<MenuVo> menuVos){
        for(MenuVo m:menuVos){
            if(m.getMid()==id){
                return m;
            }
        }
        return null;
    }



}

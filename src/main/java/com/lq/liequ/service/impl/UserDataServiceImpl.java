package com.lq.liequ.service.impl;

import com.lq.liequ.common.utils.ResultUtil;
import com.lq.liequ.common.vo.ResultVo;
import com.lq.liequ.dao.UserDataMapper;
import com.lq.liequ.pojo.UserData;
import com.lq.liequ.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDataServiceImpl implements UserDataService {

    @Autowired
    private UserDataMapper userDataMapper;

    @Override
    public ResultVo findByUname(String uname) {

        ResultVo resultVo = new ResultVo();
        try {
            List<UserData> list = userDataMapper.findAll(uname);
            resultVo = ResultUtil.exec( true, "OK", list);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo = ResultUtil.exec( false, "error", e.getMessage());
        }

        return resultVo;
    }

    @Override
    public ResultVo updateData(UserData userData) {

        ResultVo resultVo = new ResultVo();
        try {
            userDataMapper.updateByPrimaryKeySelective(userData);
            resultVo = ResultUtil.exec( true, "OK", null);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo = ResultUtil.exec( false, "error", e.getMessage());
        }

        return resultVo;
    }
}

package com.lq.liequ.service.impl;

import com.lq.liequ.common.utils.ResultUtil;
import com.lq.liequ.common.vo.ResultVo;
import com.lq.liequ.dao.UserMapper;
import com.lq.liequ.pojo.User;
import com.lq.liequ.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImol implements UserService {

    @Autowired
    private UserMapper userDao;

    /*@Override
    public List<String> queryPerms(int uid) {
        return userDao.selectByUidPerms(uid);
    }*/

    @Override
    public ResultVo login(String name, String password) {

        if (name == null || password == null) {
            throw new RuntimeException("密码或账号不能为空！");
        }

        try {
            User user = userDao.findByName(name);
            if (!user.getUpassword().equals(password)) {
                throw new RuntimeException("密码错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResultUtil.exec(true,"成功",userDao.findByName(name));
    }
}

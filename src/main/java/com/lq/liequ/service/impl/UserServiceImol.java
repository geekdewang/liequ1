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

    /**
     * 登录
     * @param name
     * @param password
     * @return
     */
    @Override
    public ResultVo login(String name, String password) {

        ResultVo res= new ResultVo();
        if (name == null || password == null) {
            throw new RuntimeException("密码或账号不能为空！");
        }

        try {
            User user = userDao.findByName(name);

            if (!user.getUpassword().equals(password)) {
                throw new RuntimeException("密码错误");
            }
            res = ResultUtil.exec(true,"成功",user.getUname());
        } catch (Exception e) {
            e.printStackTrace();
            res = ResultUtil.exec(false,"error",e.getMessage());
        }

        return res;
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @Override
    public ResultVo regist(User user) {
        ResultVo res= new ResultVo();

        try {
            User user1 = userDao.findByName(user.getUname());
            if (user1 != null) {
                throw new RuntimeException("用户名已经存在");
            }
            userDao.insertSelective(user);
            res = ResultUtil.exec(true,"OK",null);
        } catch (Exception e) {
            e.printStackTrace();
            res = ResultUtil.exec(true,"注册失败",null);
        }
        return res;
    }

    @Override
    public ResultVo update(User user) {
        ResultVo res= new ResultVo();

        try {
            User user1 = userDao.findByName(user.getUname());
            if (user1 == null) {
                throw new RuntimeException("用户名不存在");
            }
            userDao.updateByName(user);
            res = ResultUtil.exec(true,"OK",null);
        } catch (Exception e) {
            e.printStackTrace();
            res = ResultUtil.exec(true,"修改失败",null);
        }
        return res;
    }
}

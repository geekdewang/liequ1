package com.lq.liequ.dao;

import com.lq.liequ.pojo.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    // 注册
    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    //修改密码
    int updateByName(User record);

    // 登录
    User findByName(String uname);

   // List<String> selectByUidPerms(Integer uid);
}
package com.lq.liequ.dao;

import com.lq.liequ.pojo.UserData;

import java.util.List;

public interface UserDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserData record);

    int insertSelective(UserData record);

    UserData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserData record);

    int updateByPrimaryKey(UserData record);

    List<UserData> findAll(String uname);
}
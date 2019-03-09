package com.lq.liequ.service;

import com.lq.liequ.common.vo.ResultVo;
import com.lq.liequ.pojo.User;

import java.util.List;

public interface UserService {
  //  List<String> queryPerms(int uid);

    ResultVo login(String name, String password);

    ResultVo regist(User user);
}

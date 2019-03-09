package com.lq.liequ.service;

import com.lq.liequ.common.vo.ResultVo;

import java.util.List;

public interface UserService {
  //  List<String> queryPerms(int uid);

    ResultVo login(String name, String password);
}

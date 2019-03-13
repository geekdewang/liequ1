package com.lq.liequ.service;

import com.lq.liequ.common.vo.ResultVo;
import com.lq.liequ.pojo.UserData;

public interface UserDataService {
    ResultVo findByUname(String uname);

    ResultVo updateData(UserData userData);
}

package com.lq.liequ.Controller;

import com.lq.liequ.common.vo.ResultVo;
import com.lq.liequ.pojo.UserData;
import com.lq.liequ.service.UserDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Api(value = "用户信息",tags = "用户信息相关操作")
public class UserDataController {
    @Autowired
    private UserDataService userDataService;

    //展示信息
    @ApiOperation(value = "用户信息的展示",notes = "通过登录的用户名")
    @GetMapping("userdata")
    public ResultVo userDataList(String uname) {
        return userDataService.findByUname(uname);
    }
    //修改资料
    @ApiOperation(value = "用户信息的修改",notes = "用户信息的修改保存，把用户信息传递过来就好")
    @PostMapping("updatauserdata")
    public ResultVo updateData(UserData userData) {
        return userDataService.updateData(userData);
    }
}

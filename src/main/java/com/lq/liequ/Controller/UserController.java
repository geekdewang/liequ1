package com.lq.liequ.Controller;

import com.lq.liequ.common.sysconst.SystemCon;
import com.lq.liequ.common.utils.ResultUtil;
import com.lq.liequ.common.vo.ResultVo;
import com.lq.liequ.pojo.User;
import com.lq.liequ.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Api(value = "用户",tags = "用户相关操作")
public class UserController {

    @Autowired
    private UserService userService;

    //登录
    @ApiOperation(value = "登录",notes = "实现用户的登录，记得自己验空")
    @GetMapping("userlogin")
    public ResultVo login(String uname, String upassword){
        ResultVo resultVo=userService.login(uname,upassword);
        UsernamePasswordToken token = null;
        if(resultVo.getCode()== SystemCon.OK){
            //需要告知Shiro
            //1、创建登录令牌
              token =new UsernamePasswordToken(uname,upassword);
            System.out.println(token.getUsername());
            //token.setRememberMe();
            //2、获取主题
            Subject subject= SecurityUtils.getSubject();
            //3、在Session设置当前的登录用户
            subject.getSession().setAttribute("user",resultVo.getData());
           /* //4、发起认证 ---会调用Shiro对应的Realm的认证方法
            subject.login(token);*/
        }
        return resultVo;
    }
    @ApiOperation(value = "用户注册",notes = "用户注册传入没有注册过的用户名和密码")
    @PostMapping("ruseregist")
    public ResultVo regist(User user) {
        return userService.regist(user);
    }

    @ApiOperation(value = "密码修改",notes = "通过有效的用户名修改")
    @PostMapping("userupdate")
    public ResultVo userupdate(User user) {
        return userService.update(user);
    }


}

package com.lq.liequ.Controller;

import com.lq.liequ.common.sysconst.SystemCon;
import com.lq.liequ.common.utils.ResultUtil;
import com.lq.liequ.common.vo.ResultVo;
import com.lq.liequ.pojo.User;
import com.lq.liequ.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    //登录
    @RequestMapping("userlogin")
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

    @RequestMapping("ruseregist")
    public ResultVo regist(User user) {
        return userService.regist(user);
    }

}

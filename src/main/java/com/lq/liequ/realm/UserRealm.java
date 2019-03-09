package com.lq.liequ.realm;

import com.lq.liequ.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.List;


public class UserRealm extends AuthorizingRealm {

    //授权   查询登录用户的所有的权限，并返回
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //1、获取登录用户
        User user= (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        //2、查询对应的权限
        List<String> perms=userService.queryPerms(user.getId());
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        //3、设置权限到指定对象中
        authorizationInfo.addStringPermissions(perms);
        return authorizationInfo;
    }
    //认证  登录许可 标记是否登录成功
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取传递的令牌
        UsernamePasswordToken userToken=(UsernamePasswordToken) authenticationToken;
        //验证令牌是否为空
        if(userToken.getUsername()!=null){

            //创建认证信息  参数说明：1、用户名 2、密码 3、realm的名字
            SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(userToken.getUsername(),userToken.getPassword(),getName());
            return authenticationInfo;
        }
        return null;
    }
}
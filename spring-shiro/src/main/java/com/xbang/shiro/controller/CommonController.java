package com.xbang.shiro.controller;

import com.xbang.commons.entity.UserInfo;
import com.xbang.commons.vo.result.BaseResult;
import com.xbang.commons.vo.result.Result;
import com.xbang.commons.vo.result.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@Slf4j
@Controller
public class CommonController {
    @GetMapping("login")
    public String login(){
        return "login";
    }

    @PostMapping("login.do")
    @ResponseBody
    public Result doLogin(@RequestBody UserInfo userInfo){
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken();
        usernamePasswordToken.setUsername(userInfo.getUserName());
        usernamePasswordToken.setPassword(userInfo.getPassword().toCharArray());

        try {
            subject.login(usernamePasswordToken);


        }catch (AuthenticationException e){
            return BaseResult.getResult(ResultEnum.RESULT_FAIL,"账号或密码错误.");
        }
        catch (AuthorizationException e){
            return BaseResult.getResult(ResultEnum.RESULT_FAIL,"没有权限.");
        }
        return BaseResult.getResult(ResultEnum.RESULT_SUCCESS,"登录成功");
    }

    @GetMapping("some")
    @ResponseBody
    @RequiresRoles("admin")
    @RequiresPermissions("query1")
    public Result doSomething(){
        return BaseResult.getResult(ResultEnum.RESULT_SUCCESS,"");
    }

}

package com.xbang.mybatis.controller;


import com.xbang.commons.vo.result.Result;
import com.xbang.mybatis.dao.entity.TUserInfo;
import com.xbang.mybatis.service.face.ITUserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xbang
 * @since 2019-12-31
 */
@Slf4j
@RestController
@RequestMapping("/tUserInfo")
public class TUserInfoController {
    @Autowired
    private ITUserInfoService itUserInfoService;
    @PostMapping(value = "addUser",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result addUser(@RequestBody TUserInfo tUserInfo){
        log.info("tUserInfo:{}", tUserInfo);
        Result result = itUserInfoService.addUser(tUserInfo);
        log.info("userList:{}", itUserInfoService.userPage() );
        return result;
    }


    @PostMapping(value = "userPage",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result userPage(){
        return itUserInfoService.userPage();
    }
}


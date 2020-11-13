package com.xbang.cache.controller;

import com.xbang.cache.service.TestService;
import com.xbang.commons.result.BaseResult;
import com.xbang.commons.result.Result;
import com.xbang.commons.result.ResultEnum;
import com.xbang.db.dao.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Description
 *
 * @author admin
 * @version: 1.0
 * create date: 2020/11/11
 * update date: 2020/11/11
 */
@RestController
@RequestMapping("cache")
public class CacheTestController {
    @Autowired
    TestService testService;
    @GetMapping("queryById")
    public Result queryById(long id){
        return BaseResult.success(testService.queryUserInfo(id));
    }

    @GetMapping("queryByName")
    public Result queryByName(String name){
        return BaseResult.getResult(ResultEnum.SUCCESS,testService.queryUserInfoByName(name));
    }

    @PostMapping("update")
    public Result update(@RequestBody UserInfo userInfo){
        testService.updateUserInfo(userInfo);
        return Result.success();
    }
}

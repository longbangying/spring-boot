package com.xbang.mybatis.controller;

import com.xbang.commons.result.BaseResult;
import com.xbang.commons.result.Result;
import com.xbang.commons.result.ResultEnum;
import com.xbang.mybatis.service.face.TestInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestInfoController {

    @Autowired
    TestInfoService testInfoService;

    @GetMapping("add")
    public Result addInfo(String name){
        return BaseResult.getResult(ResultEnum.SUCCESS,testInfoService.addInfo(name));
    }

    @GetMapping("getInfo")
    public Result getInfo(long id){
        return BaseResult.getResult(ResultEnum.FAIL,testInfoService.getInfo(id));
    }
}

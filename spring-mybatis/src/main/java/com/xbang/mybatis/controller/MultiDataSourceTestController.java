package com.xbang.mybatis.controller;

import com.xbang.commons.result.BaseResult;
import com.xbang.commons.result.Result;
import com.xbang.commons.result.ResultEnum;
import com.xbang.mybatis.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MultiDataSourceTestController {
    @Autowired
    TestService testService;

    @GetMapping("default")
    public Result testDefault(){
        return BaseResult.getResult(ResultEnum.SUCCESS,testService.getDefault(1));
    }

    @GetMapping("master")
    public Result testMaster(){
        return BaseResult.getResult(ResultEnum.SUCCESS,testService.getMaster(1));
    }

    @GetMapping("slave")
    public Result testSlave(){
        return BaseResult.getResult(ResultEnum.SUCCESS,testService.getSlave(1));
    }
}

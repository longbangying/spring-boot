package com.xbang.mybatis.controller;

import com.xbang.commons.vo.result.BaseResult;
import com.xbang.commons.vo.result.Result;
import com.xbang.commons.vo.result.ResultEnum;
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
        return BaseResult.getResult(ResultEnum.RESULT_SUCCESS,testService.getDefault(1));
    }

    @GetMapping("master")
    public Result testMaster(){
        return BaseResult.getResult(ResultEnum.RESULT_SUCCESS,testService.getMaster(1));
    }

    @GetMapping("slave")
    public Result testSlave(){
        return BaseResult.getResult(ResultEnum.RESULT_SUCCESS,testService.getSlave(1));
    }
}

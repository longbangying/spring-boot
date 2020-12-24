package com.xbang.aop.controller;

import com.xbang.commons.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description
 *
 * @author admin
 * @version: 1.0
 * create date: 2020/12/23
 * update date: 2020/12/23
 */
@RestController
@RequestMapping("/aop")
public class TestController {
    @GetMapping("/test")
    public Result test(){
        return Result.success();
    }
}

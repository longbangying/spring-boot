package com.xbang.session.controller;

import com.xbang.commons.vo.result.BaseResult;
import com.xbang.commons.vo.result.Result;
import com.xbang.commons.vo.result.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Slf4j
@RestController
public class TestSessionController {

    @Autowired
    StringRedisTemplate  redisTemplate;
    @GetMapping("ping")
    public Result ping(HttpSession httpSession){
        httpSession.setAttribute("mes","redis");
        return BaseResult.getResult(ResultEnum.RESULT_SUCCESS, httpSession.getId());
    }


    @GetMapping("ping12")
    public Result ping12(HttpSession httpSession){
        String flag = (String) httpSession.getAttribute("mes");
        if(StringUtils.isEmpty(flag)){
            return BaseResult.getResult(ResultEnum.RESULT_FAIL, httpSession.getId());
        }
        return BaseResult.getResult(ResultEnum.RESULT_SUCCESS, flag);
    }


    @GetMapping("ping1")
    public Result ping1(){

        return BaseResult.getResult(ResultEnum.RESULT_SUCCESS, redisTemplate.keys("*"));
    }
}

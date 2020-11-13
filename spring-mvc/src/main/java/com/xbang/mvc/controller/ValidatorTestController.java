package com.xbang.mvc.controller;

import com.xbang.commons.entity.UserInfo;
import com.xbang.commons.result.BaseResult;
import com.xbang.commons.result.Result;
import com.xbang.commons.validate.Create;
import com.xbang.commons.validate.Update;
import com.xbang.mvc.dto.TestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/validated")
public class ValidatorTestController {

    @PostMapping("adduser")
    public String addUser(@RequestBody @Validated(Create.class) UserInfo userInfo){
        log.info("userInfo:{}",userInfo);
        return "success";
    }


    @PostMapping("update")
    public String update(@RequestBody @Validated(Update.class) UserInfo userInfo){
        log.info("userInfo:{}",userInfo);
        return "success";
    }

    @PostMapping("/test")
    public Result test(@RequestBody @Validated TestDTO testDTO){
        return BaseResult.success(testDTO);
    }


}

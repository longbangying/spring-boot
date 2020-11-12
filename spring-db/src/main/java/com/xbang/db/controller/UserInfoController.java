package com.xbang.db.controller;


import com.xbang.db.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2020-10-26
 */
@RestController
@RequestMapping("/user-info")
public class UserInfoController {

    @Autowired
    IUserInfoService iUserInfoService;
    @GetMapping("test")
    public Map test(){
        Map resultMap = new HashMap(16);
        resultMap.put("result",iUserInfoService.list());
        return resultMap;
    }

}

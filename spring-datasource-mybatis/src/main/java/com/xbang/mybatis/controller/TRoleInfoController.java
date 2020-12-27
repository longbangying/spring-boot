package com.xbang.mybatis.controller;


import com.xbang.commons.result.Result;
import com.xbang.mybatis.dao.entity.TRoleInfo;
import com.xbang.mybatis.service.face.ITRoleInfoService;
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
 * @since 2019-12-30
 */
@RestController
@RequestMapping("/tRoleInfo")
public class TRoleInfoController {

    @Autowired
    private ITRoleInfoService itRoleInfoService;

    @PostMapping(value = "addRole",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result addRoleInfo(@RequestBody TRoleInfo tRoleInfo){
        return itRoleInfoService.addRoleInfo(tRoleInfo);
    }

    @PostMapping("queryRoleInfo")
    public Result queryRoleInfo(long roleId){
        return itRoleInfoService.queryRoleInfo(roleId);

    }

    @PostMapping("queryRoleInfoByPage")
    public Result queryRoleInfoByPage(@RequestBody TRoleInfo tRoleInfo){
        return itRoleInfoService.queryRoleInfoByPage(tRoleInfo);

    }
}


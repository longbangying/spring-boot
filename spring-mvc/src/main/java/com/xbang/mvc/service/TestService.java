package com.xbang.mvc.service;

import com.xbang.multi.datasource.annotation.support.DS;
import com.xbang.mybatis.entity.UserInfo;
import com.xbang.mybatis.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@DS("slave")
@Component
public class TestService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public UserInfo getDefault(long id){
        return userInfoMapper.selectById(id);
    }

    @DS
    public UserInfo getMaster(long id){
        return userInfoMapper.selectById(id);
    }
    @DS("slave")
    public UserInfo getSlave(long id){
        return userInfoMapper.selectById(id);
    }

}

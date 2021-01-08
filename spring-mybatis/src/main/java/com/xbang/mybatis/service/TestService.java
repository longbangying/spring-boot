package com.xbang.mybatis.service;

import com.xbang.multi.datasource.support.annotation.DS;
import com.xbang.mybatis.entity.UserInfo;
import com.xbang.mybatis.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestService {

    @Autowired
    UserInfoMapper userInfoMapper;


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

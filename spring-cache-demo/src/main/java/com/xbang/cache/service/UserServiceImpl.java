package com.xbang.cache.service;

import com.xbang.cache.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
//@Scope("prototype")

@CacheConfig(cacheNames = "userInfo")
public class UserServiceImpl implements UserService{

    private static final Map<String,UserInfo> userInfoMap = new ConcurrentHashMap<>();

    static {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("xbang001");
        userInfo.setUserName("超级管理员");
        userInfo.setAddress("北京");
        userInfo.setAge(35);
        userInfoMap.put(userInfo.getUserId(),userInfo);

        UserInfo userInfo1 = new UserInfo();
        userInfo1.setUserId("xbang002");
        userInfo1.setUserName("超级管理员");
        userInfo1.setAddress("北京");
        userInfo1.setAge(35);
        userInfoMap.put(userInfo1.getUserId(), userInfo1);
    }

    @Override
    @Cacheable(/*value = "user",*/key = "#userId")
    public UserInfo getUserInfo(String userId) {
        log.info("查询：{}", userId);
        return userInfoMap.get(userId);
    }


    @Override
    @Cacheable(key = "#userId")
    public UserInfo getUserInfo1(String userId) {
        log.info("查询：{}", userId);
        return userInfoMap.get(userId);
    }


    @Override
    public UserInfo addUserInfo(UserInfo userInfo) {
        return null;
    }
}

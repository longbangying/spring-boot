package com.xbang.cache.service;

import com.xbang.cache.entity.UserInfo;

public interface UserService {

    UserInfo getUserInfo(String userId);

    UserInfo addUserInfo(UserInfo userInfo);

    UserInfo getUserInfo1(String userId);
}

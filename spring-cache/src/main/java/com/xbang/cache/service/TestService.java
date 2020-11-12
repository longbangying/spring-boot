package com.xbang.cache.service;

import com.xbang.db.dao.entity.UserInfo;

/**
 * Description
 *
 * @author admin
 * @version: 1.0
 * create date: 2020/11/11
 * update date: 2020/11/11
 */
public interface TestService {
    /**
     * 通过ID查询用户信息
     * @param userId
     * @return
     */
    UserInfo queryUserInfo(Long userId);

    /**
     * 通过用户名查询用户信息
     * @param userName
     * @return
     */
    UserInfo queryUserInfoByName(String userName);

    /**
     * 更新
     * @param userInfo
     */
    void updateUserInfo(UserInfo userInfo);


}

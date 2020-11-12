package com.xbang.cache.service;

import com.xbang.db.dao.entity.UserInfo;
import com.xbang.db.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Description
 *
 * @author admin
 * @version: 1.0
 * create date: 2020/11/11
 * update date: 2020/11/11
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    IUserInfoService iUserInfoService;
    @Cacheable(value = "queryUserInfo",key = "#userId")
    @Override
    public UserInfo queryUserInfo(Long userId) {
        return iUserInfoService.getById(userId);
    }
    @Cacheable(value = "queryUserInfoByName",key = "#userName")
    @Override
    public UserInfo queryUserInfoByName(String userName) {
        return iUserInfoService.lambdaQuery().eq(UserInfo::getUserName,userName).one();
    }

    /**
     * 更新成功后根据缓存名称+ key 去清除相关的缓存
     * @param userInfo
     */
    @CacheEvict(value = {"queryUserInfo","queryUserInfoByName"},key = "#userInfo.id")
    @Override
    public void updateUserInfo(UserInfo userInfo) {
        if(null == userInfo){
            return ;
        }
        if(StringUtils.isEmpty(userInfo.getUserName())){
            return ;
        }
        iUserInfoService.lambdaUpdate()
                .set(UserInfo::getUserName,userInfo.getUserName()).eq(UserInfo::getId,userInfo.getId()).update();

    }
}

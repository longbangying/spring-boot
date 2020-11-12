package com.xbang.db.service.impl;


import com.xbang.db.dao.entity.UserInfo;
import com.xbang.db.service.IUserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;


/**
 * Description
 *
 * @author admin
 * @version: 1.0
 * create date: 2020/10/26
 * update date: 2020/10/26
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserInfoServiceImplTest {
    @Autowired
    IUserInfoService iUserInfoService;


    @Test
    public void  testInsert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("张三");
        userInfo.setCreatedBy("system");
        userInfo.setDateCreated(LocalDateTime.now());
        userInfo.setDateUpdated(LocalDateTime.now());
        userInfo.setUpdatedBy(userInfo.getCreatedBy());
        boolean result = iUserInfoService.save(userInfo);
        System.out.println(result);
    }


    @Test
    public void testQuery(){
        List<UserInfo> userInfoList = this.iUserInfoService.lambdaQuery().list();
        userInfoList.forEach(System.out::println);
    }

}

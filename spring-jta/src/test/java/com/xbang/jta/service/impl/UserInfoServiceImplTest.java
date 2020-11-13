package com.xbang.jta.service.impl;

import com.xbang.jta.dao.entity.UserInfo;
import com.xbang.jta.dao.mapper.db1.UserInfoDb1Mapper;
import com.xbang.jta.dao.mapper.db2.UserInfoDb2Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * Description
 *
 * @author admin
 * @version: 1.0
 * create date: 2020/11/13
 * update date: 2020/11/13
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserInfoServiceImplTest {

    @Autowired
    UserInfoDb1Mapper userInfoDb1Mapper;
    @Autowired
    UserInfoDb2Mapper userInfoDb2Mapper;
    @Test
    public void test(){
        UserInfo userInfo = userInfoDb1Mapper.selectById(1);
        System.out.println(userInfo);
    }


}

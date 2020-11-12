package com.xbang.mybatis.mapper;

import com.xbang.mybatis.entity.UserFullInfo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;


@SpringBootTest
@RunWith(SpringRunner.class)
public class UserInfoMapperTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    UserInfoMapper userInfoMapper;
    @Test
    public  void createDeployment() {
       /* UserFullInfo userFullInfo = userInfoMapper.testCollection();
        logger.info("userFullInfo:{}",userFullInfo);

        Map  roleMap = userInfoMapper.queryRoleInfo();*/
        Map userInfo = userInfoMapper.selectUserInfo("2");
        logger.info("roleMap:{}",userInfo);
    }

}

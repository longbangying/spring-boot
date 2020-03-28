package com.xbang.mybatis;

import com.xbang.mybatis.entity.UserInfo;
import com.xbang.mybatis.mapper.UserInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@MapperScan("com.xbang.mybatis.mapper")
public class MybatisApplication implements CommandLineRunner {

    @Autowired
    UserInfoMapper userInfoMapper;

    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("詹姆斯6");
        //userInfoMapper.insert(userInfo);
    }
}

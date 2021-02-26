package com.xbang.postgresql.dao;


import com.xbang.postgresql.entity.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description
 *
 * @author admin
 * @version: 1.0
 * create date: 2021/1/16
 * update date: 2021/1/16
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserInfoMapperTest {
    @Autowired
    UserInfoMapper userInfoMapper;

    @Test
    public void test(){
        List<UserInfo> list = userInfoMapper.selectAll();
        if(null != list){
            list.stream().forEach(System.out::println);
        }
    }


    @Test
    public void testInsert(){
        for (int i=10000;i< 100000;i++){
            Map map = new HashMap();
            map.put("id",i);
            map.put("name","张三"+ i);
            map.put("address","广东省深圳市龙岗区坂田街道");

            userInfoMapper.insert(map);
        }
    }
}
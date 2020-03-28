package com.xbang.cache;


import com.xbang.cache.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisConnectionUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringCacheDemoApplicationTest {

    @Autowired
    private StringRedisTemplate redisTemplate;

    //string test
    @Test
    public void test1(){
        String value = (String)redisTemplate.opsForValue().get("long");
        try {
            Set<String> keys = redisTemplate.keys("*");
            log.info("keys:{}",keys);
            UserInfo userInfo = initUserInfo();
            Jedis jedis = new Jedis();
            

        } catch (Exception e) {
            log.error("error:{}",e.getMessage());
        }


    }


    public UserInfo initUserInfo(){
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(18);
        userInfo.setUserName("张三");
        userInfo.setAddress("北京");
        userInfo.setUserId(UUID.randomUUID().toString());
        return userInfo;
    }

    @Test
    public void testHash(){
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(18);
        userInfo.setUserName("张三");
        userInfo.setAddress("北京");
        userInfo.setUserId(UUID.randomUUID().toString());

        Map map = null;
        try {
            map = beanToMap(userInfo);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        redisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(UserInfo.class));
        BoundHashOperations boundHashOperations = redisTemplate.boundHashOps("hash");
        log.info("setValueSerializer:{}",redisTemplate.getHashKeySerializer().toString());
        boundHashOperations.putAll(map);
        Map map1 = boundHashOperations.entries();
        log.info("map:{}",map1);
    }


    private static Map beanToMap(Object object) throws IllegalArgumentException, IllegalAccessException{
        Class clazz = object.getClass();
        Field [] fields = clazz.getDeclaredFields();
        Map<String,Object> result = new HashMap<>();
        for (Field field : fields) {
            if(!field.isAccessible()){
                field.setAccessible(true);
            }
            result.put(field.getName(),field.get(object));

            
        }


        return result;
    }


    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException{
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(18);
        userInfo.setUserName("张三");
        userInfo.setAddress("北京");
        userInfo.setUserId(UUID.randomUUID().toString());

        System.out.println(beanToMap(userInfo));
    }






}

package com.xbang.postgresql.service;

import com.xbang.postgresql.dao.UserAttrMapper;
import com.xbang.postgresql.dao.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * Description
 *
 * @author admin
 * @version: 1.0
 * create date: 2021/1/16
 * update date: 2021/1/16
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    UserAttrMapper userAttrMapper;

    @Autowired
    UserInfoMapper userInfoMapper;
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void testInsert() {
        int userId = 100000;
        Map userInfo  = new HashMap(8);
        userInfo.put("id",userId);
        userInfo.put("name","张三"+ userId);
        userInfo.put("address","广东省深圳市龙岗区坂田街道");
        userInfo.put("remark","test");
        userInfo.put("note","test");


        Map attrInfo = new HashMap(4);
        attrInfo.put("id",1);
        attrInfo.put("userId",userId);
        attrInfo.put("attrInfo",userInfo.toString());

        userInfoMapper.insert(userInfo);
        if(1== 1){
            throw new RuntimeException("测试");
        }
        userAttrMapper.insert(attrInfo);


    }
}

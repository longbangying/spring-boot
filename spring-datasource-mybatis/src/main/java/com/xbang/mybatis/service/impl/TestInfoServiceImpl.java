package com.xbang.mybatis.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.xbang.mybatis.dao.entity.TTestInfo;
import com.xbang.mybatis.dao.mapper.TestInfoMapper;
import com.xbang.mybatis.service.face.TestInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestInfoServiceImpl implements TestInfoService {
    @Autowired
    TestInfoMapper testInfoMapper;

    @Override
    public TTestInfo addInfo(String name) {
        TTestInfo tTestInfo = new TTestInfo();
        tTestInfo.setName(name);
        testInfoMapper.insert(tTestInfo);
        return tTestInfo;
    }

    @Override
    @DS("slave")
    public TTestInfo getInfo(long id) {
        TTestInfo tTestInfo = testInfoMapper.selectById(id);
        return tTestInfo;
    }
}

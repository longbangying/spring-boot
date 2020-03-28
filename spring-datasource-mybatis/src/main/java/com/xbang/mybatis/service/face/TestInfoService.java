package com.xbang.mybatis.service.face;

import com.xbang.mybatis.dao.entity.TTestInfo;

public interface TestInfoService {

    TTestInfo addInfo(String name);

    TTestInfo getInfo(long id);
}

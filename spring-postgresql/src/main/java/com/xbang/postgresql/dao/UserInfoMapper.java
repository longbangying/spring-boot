package com.xbang.postgresql.dao;

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
public interface UserInfoMapper {
    List<Map> getAll();

    int insert(Map map);
}

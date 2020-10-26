package com.xbang.db.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Description
 *
 * @author admin
 * @version: 1.0
 * create date: 2020/10/26
 * update date: 2020/10/26
 */
@Configuration
@MapperScan("com.xbang.db.dao.mapper")
public class DbConfig {
}

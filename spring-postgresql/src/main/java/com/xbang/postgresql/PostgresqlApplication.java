package com.xbang.postgresql;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Description
 *
 * @author admin
 * @version: 1.0
 * create date: 2021/1/16
 * update date: 2021/1/16
 */
@SpringBootApplication
@MapperScan("com.xbang.postgresql.dao")
public class PostgresqlApplication {
    public static void main(String[] args) {
        SpringApplication.run(PostgresqlApplication.class,args);
    }
}

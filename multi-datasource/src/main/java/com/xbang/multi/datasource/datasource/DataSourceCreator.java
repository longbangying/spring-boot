package com.xbang.multi.datasource.datasource;

import com.xbang.multi.datasource.config.DataSourceProperty;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DataSourceCreator {

    public static HikariDataSource hikariDataSource(DataSourceProperty dataSourceProperty){
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(dataSourceProperty.getClassName());
        hikariConfig.setUsername(dataSourceProperty.getUserName());
        hikariConfig.setPassword(dataSourceProperty.getPassword());
        hikariConfig.setJdbcUrl(dataSourceProperty.getUrl());
        return new HikariDataSource(hikariConfig);
    }
}

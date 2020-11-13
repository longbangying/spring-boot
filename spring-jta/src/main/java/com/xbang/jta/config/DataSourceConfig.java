package com.xbang.jta.config;

import com.alibaba.druid.pool.xa.DruidXADataSource;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Description   数据源配置(两个数据源)
 *
 * @author admin
 * @version: 1.0
 * create date: 2020/11/13
 * update date: 2020/11/13
 */
@Configuration
public class DataSourceConfig {

    public static final String DB_CLASS_NAME = "com.alibaba.druid.pool.xa.DruidXADataSource";

    /**
     * 数据库1
     * @param environment
     * @return
     */
    @Bean
    public DataSource dataSource1(Environment environment){
        Properties properties = build(environment,"spring.datasource.db1");
        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaProperties(properties);
        //className
        atomikosDataSourceBean.setXaDataSourceClassName(DB_CLASS_NAME);
        atomikosDataSourceBean.setUniqueResourceName("db1");
        atomikosDataSourceBean.setPoolSize(10);
        return atomikosDataSourceBean;
    }

    /**
     * 数据库2
     * @param environment
     * @return
     */
    @Bean
    public DataSource dataSource2(Environment environment){
        Properties properties = build(environment,"spring.datasource.db2");
        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaProperties(properties);
        //className
        atomikosDataSourceBean.setXaDataSourceClassName(DB_CLASS_NAME);
        atomikosDataSourceBean.setUniqueResourceName("db2");
        atomikosDataSourceBean.setPoolSize(10);
        return atomikosDataSourceBean;
    }


    private Properties build(Environment environment,String perfix){
        Properties properties = new Properties();
        properties.put("url",environment.getProperty(perfix+".url"));
        properties.put("username",environment.getProperty(perfix+".username"));
        properties.put("password",environment.getProperty(perfix+".password"));
        return properties;
    }
}

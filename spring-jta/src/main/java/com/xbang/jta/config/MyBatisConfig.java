package com.xbang.jta.config;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;

/**
 * Description
 *
 * @author admin
 * @version: 1.0
 * create date: 2020/11/13
 * update date: 2020/11/13
 */
@Configuration
@MapperScan(basePackages = "com.xbang.jta.dao.mapper.db1",markerInterface = BaseMapper.class,sqlSessionFactoryRef = "sqlSessionFactory1")
@MapperScan(basePackages = "com.xbang.jta.dao.mapper.db2",markerInterface = BaseMapper.class,sqlSessionFactoryRef = "sqlSessionFactory2")
public class MyBatisConfig {
    /**
     * 数据源1
     */
    @Autowired
    @Qualifier("dataSource1")
    DataSource dataSource1;

    /**
     * 数据源2
     */
    @Autowired
    @Qualifier("dataSource2")
    DataSource dataSource2;


    @Bean
    @Primary
    public SqlSessionFactory sqlSessionFactory1() throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource1);
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resourcePatternResolver.getResources("classpath*:mapper/db1/**/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate1() throws Exception{
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory1());
        return sqlSessionTemplate;
    }


    @Bean
    @Primary
    public SqlSessionFactory sqlSessionFactory2() throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource2);
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resourcePatternResolver.getResources("classpath*:mapper/db2/**/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate2() throws Exception{
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory2());
        return sqlSessionTemplate;
    }

}

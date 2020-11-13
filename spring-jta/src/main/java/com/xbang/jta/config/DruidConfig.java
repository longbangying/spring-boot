package com.xbang.jta.config;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * Description
 *
 * @author admin
 * @version: 1.0
 * create date: 2020/11/13
 * update date: 2020/11/13
 */
@Configuration
public class DruidConfig {
    /**
     * 注册servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean druidServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        StatViewServlet statViewServlet = new StatViewServlet();
        servletRegistrationBean.setServlet(statViewServlet);
        servletRegistrationBean.setUrlMappings(Arrays.asList("/druid/**"));
        servletRegistrationBean.addInitParameter("loginUserName","admin");
        servletRegistrationBean.addInitParameter("loginPassword","admin");
        return servletRegistrationBean;
    }

    /**
     * 注册 filter
     * @return
     */
    @Bean
    public FilterRegistrationBean druidFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,./druid/*");
        filterRegistrationBean.addInitParameter("profileEnable","true");
        return filterRegistrationBean;
    }

    @Bean
    public StatFilter statFilter(){
        StatFilter statFilter = new StatFilter();
        statFilter.setLogSlowSql(true);
        statFilter.setMergeSql(true);
        statFilter.setSlowSqlMillis(3000);
        return statFilter;
    }

    @Bean
    public WallFilter wallFilter(){
        WallFilter wallFilter = new WallFilter();
        WallConfig wallConfig = new WallConfig();
        wallConfig.setMultiStatementAllow(true);
        wallFilter.setConfig(wallConfig);
        return wallFilter;
    }
}

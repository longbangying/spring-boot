package com.xbang.multi.datasource.config;

import com.xbang.multi.datasource.datasource.DataSourceCreator;
import com.xbang.multi.datasource.datasource.DataSourceHodler;
import com.xbang.multi.datasource.datasource.MyMultiDataSource;
import com.xbang.multi.datasource.datasource.advisor.DynamicDataSourceAnnotationAdvisor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;


@Configuration
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
@ConditionalOnClass(MyMultiDataSource.class)
@EnableConfigurationProperties({MultiDataSourceProperty.class})
@ConditionalOnProperty(prefix = "multi.datasource",name = "enabled",havingValue = "true")
public class MultiDataSourceAutoConfig {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private MultiDataSourceProperty multiDataSourceProperty;

    public MultiDataSourceAutoConfig(MultiDataSourceProperty multiDataSourceProperty) {
        this.multiDataSourceProperty = multiDataSourceProperty;
    }
    @Bean
    public DynamicDataSourceAnnotationAdvisor dynamicDataSourceAnnotationAdvisor(){
        DynamicDataSourceAnnotationAdvisor dynamicDataSourceAnnotationAdvisor = new DynamicDataSourceAnnotationAdvisor();
        dynamicDataSourceAnnotationAdvisor.setOrder(-2147483648);
        return dynamicDataSourceAnnotationAdvisor;
    }



    @Bean
    public DataSource dataSource(){

        if(null == multiDataSourceProperty){
            return null;
        }
        Map<String, DataSourceProperty> config = multiDataSourceProperty.getDatasource();
        if(null == config || config.isEmpty()){
            return null;
        }
        Map<Object,Object> dataSourceMap = new LinkedHashMap<>();
        Iterator iterator = config.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry<String, DataSourceProperty> item = (Map.Entry<String, DataSourceProperty>)iterator.next();
            dataSourceMap.put(item.getKey(), DataSourceCreator.hikariDataSource(item.getValue()));

        }

        DataSourceHodler.setDataSource(multiDataSourceProperty.getKey());
        MyMultiDataSource myMultiDataSource = new MyMultiDataSource(dataSourceMap.get(multiDataSourceProperty.getKey()),dataSourceMap);
        return myMultiDataSource;
    }

}

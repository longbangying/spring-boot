package com.xbang.multi.datasource.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.LinkedHashMap;
import java.util.Map;
@ConfigurationProperties(prefix = "multi.datasource")
public class MultiDataSourceProperty {

    private String key;

    private Map<String, DataSourceProperty> datasource = new LinkedHashMap<>();

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Map<String, DataSourceProperty> getDatasource() {
        return datasource;
    }

    public void setDatasource(Map<String, DataSourceProperty> datasource) {
        this.datasource = datasource;
    }



}

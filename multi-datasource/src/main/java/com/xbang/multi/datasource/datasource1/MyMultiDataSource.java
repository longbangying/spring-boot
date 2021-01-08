package com.xbang.multi.datasource.datasource1;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.Map;

public class MyMultiDataSource extends AbstractRoutingDataSource {

    public MyMultiDataSource(Object defaultDataSource, Map<Object,Object> candidateDataSource) {
       super.setDefaultTargetDataSource(defaultDataSource);
       super.setTargetDataSources(candidateDataSource);
       super.afterPropertiesSet();
    }





    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceHodler.getDataSource();
    }
}

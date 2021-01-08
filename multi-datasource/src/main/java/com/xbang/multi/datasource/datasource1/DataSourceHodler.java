package com.xbang.multi.datasource.datasource1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataSourceHodler {

    private static volatile ThreadLocal<String> datasourceHodler = new ThreadLocal();


    public static void setDataSource(String dataSource){
        log.info("datasource1 change to {}",dataSource);
        datasourceHodler.set(dataSource);
    }

    public static String getDataSource(){
        return datasourceHodler.get();
    }
}

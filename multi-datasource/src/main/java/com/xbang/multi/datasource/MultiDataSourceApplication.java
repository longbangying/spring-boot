package com.xbang.multi.datasource;


import lombok.extern.slf4j.Slf4j;
import com.xbang.multi.datasource.config.MultiDataSourceProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@Slf4j
@SpringBootApplication
@EnableConfigurationProperties({MultiDataSourceProperty.class})
public class MultiDataSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiDataSourceApplication.class,args);

    }

}

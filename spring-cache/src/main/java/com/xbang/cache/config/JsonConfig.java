package com.xbang.cache.config;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.xbang.commons.utils.LocalDateUtils;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Description  时间转json配置
 *
 * @author admin
 * @version: 1.0
 * create date: 2020/11/13
 * update date: 2020/11/13
 */
@Configuration
public class JsonConfig implements Jackson2ObjectMapperBuilderCustomizer {
    @Override
    public void customize(Jackson2ObjectMapperBuilder jacksonObjectMapperBuilder) {
        jacksonObjectMapperBuilder.serializerByType(LocalDate.class,localDateSerializer());
        jacksonObjectMapperBuilder.serializerByType(LocalDateTime.class,localDateTimeSerializer());
    }


    @Bean
    public LocalDateTimeSerializer localDateTimeSerializer(){
        return new LocalDateTimeSerializer(LocalDateUtils.DATE_TIME_FORMATTER);
    }

    @Bean
    public LocalDateSerializer localDateSerializer(){
        return new LocalDateSerializer(LocalDateUtils.DATE_FORMATTER);
    }
}

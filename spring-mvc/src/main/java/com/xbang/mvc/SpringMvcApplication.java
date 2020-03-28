package com.xbang.mvc;

import com.xbang.commons.entity.LocalDateTimeEntity;
import com.xbang.multi.datasource.datasource.advisor.DynamicDataSourceAnnotationAdvisor;
import com.xbang.mvc.annotation.UserId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@SpringBootApplication(scanBasePackages = {"com.xbang.mvc","com.xbang.mybatis"})
@RestController
public class SpringMvcApplication {

    public static void main(String[] args) {
        ApplicationContext context  = SpringApplication.run(SpringMvcApplication.class, args);
        DynamicDataSourceAnnotationAdvisor dynamicDataSourceAnnotationAdvisor = context.getBean(DynamicDataSourceAnnotationAdvisor.class);
        Assert.notNull(dynamicDataSourceAnnotationAdvisor,"找不到这个bean");
    }

    @GetMapping("/test")
    public String test(@UserId String userId){
        log.info("userId:{}",userId);
        return userId;
    }

    @PostMapping("/localdatetime")
    public  LocalDateTimeEntity  testDateFormater(){
        LocalDateTimeEntity entity = new LocalDateTimeEntity();
        entity.setTime(LocalDateTime.now());
        entity.setType("LocalDateTime");
        log.info("param:{}",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(entity.getTime()));
        return entity;
    }

    @PostMapping("/testlocaldatetime")
    public  String  testDateFormater(@RequestBody LocalDateTimeEntity entity){

        log.info("param:{}",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(entity.getTime()));
        return "success";
    }
}

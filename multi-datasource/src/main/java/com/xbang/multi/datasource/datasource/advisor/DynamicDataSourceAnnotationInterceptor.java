package com.xbang.multi.datasource.datasource.advisor;

import com.xbang.multi.datasource.annotation.support.DS;
import com.xbang.multi.datasource.datasource.DataSourceHodler;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.reflect.Method;

/**
 * aop 增强拦截器
 *
 */
@Slf4j
public class DynamicDataSourceAnnotationInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        DataSourceHodler.setDataSource(determineDatasource(methodInvocation));
        return methodInvocation.proceed();
    }

    private String determineDatasource(MethodInvocation invocation) throws Throwable{
        Method method = invocation.getMethod();
        //获取到注解中配置的数据库的key值
        DS ds = method.isAnnotationPresent(DS.class) ? (DS)method.getAnnotation(DS.class) : (DS) AnnotationUtils.findAnnotation(invocation.getMethod().getDeclaringClass(), DS.class);
        log.info("ds:{}",ds.value());
        return ds.value();

    }
}

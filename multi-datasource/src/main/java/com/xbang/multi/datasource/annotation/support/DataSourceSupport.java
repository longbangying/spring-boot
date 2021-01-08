package com.xbang.multi.datasource.annotation.support;

import com.xbang.multi.datasource.datasource1.DataSourceHodler;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

import java.lang.reflect.Method;
//表明这是一个切面类
//@Aspect
//声明一个bean
//@Component
public class DataSourceSupport {
    /**
     * 切入点
     * 此方法拦截不到类级别的注解
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("@annotation(com.xbang.multi.datasource1.annotation.support.DS)")
    public Object support(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        String methodName = proceedingJoinPoint.getStaticPart().getSignature().getName();
        Class clazz = proceedingJoinPoint.getTarget().getClass();
        Method method = getMethodByName(methodName,clazz.getMethods());
        if(null  == method){
            return proceedingJoinPoint.proceed();
        }

        DS ds = method.getAnnotation(DS.class);
        if(null == ds){
            ds = (DS) clazz.getAnnotation(DS.class);
        }
        if(null == ds){
            return proceedingJoinPoint.proceed();
        }

        String dbKey = ds.value();
        DataSourceHodler.setDataSource(dbKey);
        return proceedingJoinPoint.proceed();
    }


    private Method getMethodByName(String name,Method [] methods){
        for(Method method : methods){
            if(method.getName().equals(name)){
                return method;
            }
        }
        return null;

    }

}

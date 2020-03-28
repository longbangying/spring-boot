package com.xbang.multi.datasource.datasource.advisor;

import com.xbang.multi.datasource.annotation.support.DS;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;
@Slf4j
//@Component
public class DynamicDataSourceAnnotationAdvisor extends AbstractPointcutAdvisor implements BeanFactoryAware {

    @Override
    public Pointcut getPointcut() {
        return buildPointcut();
    }

    @Override
    public Advice getAdvice() {
        return new DynamicDataSourceAnnotationInterceptor();
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }



    private Pointcut buildPointcut() {
        Pointcut cpc = new AnnotationMatchingPointcut(DS.class, true);
        //return cpc;
        //这部分的作用是?
        Pointcut mpc = AnnotationMatchingPointcut.forMethodAnnotation(DS.class);
        return (new ComposablePointcut(cpc)).union(mpc);
    }
}

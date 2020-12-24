package com.xbang.aop.testaop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Description
 *
 * @author admin
 * @version: 1.0
 * create date: 2020/12/23
 * update date: 2020/12/23
 */
@Component
@Aspect
public class TestAop {
    @Before("execution(public * com.xbang.aop.controller..*.*(..))")
    public void before(){
        System.out.println("进来了...");
    }
}

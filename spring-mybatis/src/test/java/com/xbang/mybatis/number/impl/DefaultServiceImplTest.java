package com.xbang.mybatis.number.impl;

import com.xbang.mybatis.number.service.NumberLoadService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author admin
 * @date 2020/5/14
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DefaultServiceImplTest {

    @Autowired
    NumberLoadService numberLoadService;


    @Test
    public void loadNumber() {

        numberLoadService.loadNumber();

    }
}

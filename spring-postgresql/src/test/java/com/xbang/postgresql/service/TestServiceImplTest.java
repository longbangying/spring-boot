package com.xbang.postgresql.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Description
 *
 * @author admin
 * @version: 1.0
 * create date: 2021/1/16
 * update date: 2021/1/16
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestServiceImplTest {
    @Autowired
    TestService testService;
    @Test
    public void testInsert() {
        testService.testInsert();
    }
}
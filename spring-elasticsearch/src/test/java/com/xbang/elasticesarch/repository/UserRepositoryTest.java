package com.xbang.elasticesarch.repository;


import com.xbang.elasticesarch.entity.UserEs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @Test
    public void addDoc(){
        UserEs userEs = new UserEs();
        userEs.setId(1L);
        userEs.setUserName("张三");
        userEs.setUserPhone("110");
        //UserEs userEs1 = userRepository.save(userEs);

    }

}

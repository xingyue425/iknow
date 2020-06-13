package com.zk.knowdatasource.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SystemMapperTest {

    @Autowired
    private SystemMapper mapper;

    @Test
    public void linkDb(){

        System.out.println(mapper.linkDb());
    }
}

package com.zk.knowdatasource.mapper;

import com.zk.knowdatasource.pojo.SalePoint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SalePointMapperTest {

    @Autowired
    private SalePointMapper salePointMapper;

    @Test
    public void findById(){

        SalePoint salePoint=salePointMapper.findById(1L);
        System.out.println(salePoint.getDbKey());
        System.out.println(salePoint.getDbName());
        System.out.println(salePoint.getDriverClassName());
        System.out.println(salePoint.getId());
        System.out.println(salePoint.getIp());
        System.out.println(salePoint.getPassword());
        System.out.println(salePoint.getUserName());
        System.out.println(salePoint.getPort());
    }
}

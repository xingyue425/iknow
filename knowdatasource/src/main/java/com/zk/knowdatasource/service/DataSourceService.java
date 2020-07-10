package com.zk.knowdatasource.service;

import com.zk.knowdatasource.mapper.SalePointMapper;
import com.zk.knowdatasource.pojo.SalePoint;
import org.apache.ibatis.annotations.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataSourceService {

    private static Logger log= LoggerFactory.getLogger(DataSourceService.class);

    @Autowired
    private SalePointMapper salePointMapper;

    public List<Map> getDataSourceMap(){
        //拼接数据源Map
        List<Map> dataSourceMap=new ArrayList<Map>();

        List<SalePoint> salePoints=salePointMapper.findSalePointList();
        if (salePoints!=null && salePoints.size()>0){
            for(SalePoint salePoint:salePoints){

                log.debug(String.format("数据源 %s %s %s",salePoint.getIp(),salePoint.getPort(),salePoint.getDbName()));
                Map<String,String> dataSource=new HashMap<String,String>();
                dataSource.put("key",salePoint.getDbKey());
                dataSource.put("username",salePoint.getUserName());
                dataSource.put("password",salePoint.getPassword());
                dataSource.put("driver-class-name",salePoint.getDriverClassName());
                dataSource.put("url",getDataSourceUrl(salePoint.getIp(),salePoint.getPort(),salePoint.getDbName()));
                dataSourceMap.add(dataSource);
            }
        }
        return dataSourceMap;
    }
    private String getDataSourceUrl(String ip,Integer port,String dbName){
        String key="jdbc:mysql://%s:%s/%s?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
        String url=String.format(key,ip,port,dbName);
        return url;
    }
}

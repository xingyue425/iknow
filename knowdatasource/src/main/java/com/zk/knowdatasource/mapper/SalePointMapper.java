package com.zk.knowdatasource.mapper;

import com.zk.knowdatasource.pojo.SalePoint;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SalePointMapper {

    public SalePoint findById(@Param("id") Long id);
}

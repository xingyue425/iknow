package com.zk.knowdatasource.mapper;

import com.zk.knowdatasource.pojo.SalePoint;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SalePointMapper {

    public SalePoint findById(@Param("id") Long id);

    public List<SalePoint> findSalePointList();
}

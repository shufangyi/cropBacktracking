package com.cbt.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cbt.system.mapper.ProductPlanUnitInfoMapper;
import com.cbt.system.po.ProductPlanUnitInfo;
import com.cbt.system.service.ProductPlanUnitInfoService;

@Service
public class ProductPlanUnitInfoServiceImpl implements ProductPlanUnitInfoService{
	
	@Resource(name="productPlanUnitInfoMapper")
	private ProductPlanUnitInfoMapper productPlanUnitInfoMapper;
	
	@Override
	public List<ProductPlanUnitInfo> getAllPpuInfo(ProductPlanUnitInfo ppuinfo) 
	{	
		return productPlanUnitInfoMapper.getAllPpuInfo(null);
	}
}

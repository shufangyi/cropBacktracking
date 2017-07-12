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

	//insert a new unit
	@Override
	public int insertNewUnitService(ProductPlanUnitInfo productPlanUnitInfo) throws Exception {
		return productPlanUnitInfoMapper.insertNewUnit(productPlanUnitInfo);
	}

	//delete unit by id
	@Override
	public int deleteUnitByIdService(ProductPlanUnitInfo productPlanUnitInfo) throws Exception {
		return productPlanUnitInfoMapper.deleteUnitById(productPlanUnitInfo);
	}

	//query all units
	@Override
	public List<ProductPlanUnitInfo> queryAllUnitService() throws Exception {
		return productPlanUnitInfoMapper.queryAllUnit();
	}
	

}

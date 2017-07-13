package com.cbt.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbt.system.mapper.ProductPlanInfoMapper;
import com.cbt.system.po.ProductPlanInfo;


@Service
public class ProductPlanInfoServiceImpl implements com.cbt.system.service.ProductPlanInfoService {

	
	@Autowired
	private ProductPlanInfoMapper productPlanInfoMapper;
	//根据生产计划查询出对应的PlanId
	@Override
	public int selectIdByPlanUnitService(String planunit) throws Exception {
		// TODO Auto-generated method stub
		return productPlanInfoMapper.selectIdByPlanUnit(planunit);
	}
	//插入一个新的生产计划
	@Override
	public int insertNewProductPlanService(ProductPlanInfo productPlanInfo) throws Exception {
		// TODO Auto-generated method stub
		return productPlanInfoMapper.insertNewProductPlan(productPlanInfo);

	}
	//删除生产计划
	@Override
	public int deleteProductPlanService(Integer planId) throws Exception {
		// TODO Auto-generated method stub
		return productPlanInfoMapper.deleteProductPlan(planId);
	}
	//query all product plan
	@Override
	public List<ProductPlanInfo> queryAllProductPlanService() throws Exception {
		// TODO Auto-generated method stub
		return productPlanInfoMapper.queryAllProductPlan();
	}
	
	//update by planId
	@Override
	public int updatePlanByIdService(ProductPlanInfo productPlanInfo) throws Exception {
		// TODO Auto-generated method stub
		return productPlanInfoMapper.updatePlanById(productPlanInfo);
	}

}

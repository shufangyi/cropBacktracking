package com.cbt.system.service;

import java.util.List;

import com.cbt.system.po.ProductPlanInfo;

public interface ProductPlanInfoService{
	
	//根据生产计划查询出对应的PlanId
	public int selectIdByPlanUnitService(String planunit)throws Exception;
	//插入一个新的生产计划
	public int insertNewProductPlanService(ProductPlanInfo productPlanInfo)throws Exception;
	//删除生产计划
	public int deleteProductPlanService(Integer planId)throws Exception;
	//query all product plan
	public List<ProductPlanInfo> queryAllProductPlanService()throws Exception;
	//update by id
	public int updatePlanByIdService(ProductPlanInfo productPlanInfo)throws Exception;
	

}

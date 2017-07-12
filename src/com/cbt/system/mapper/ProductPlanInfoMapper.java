package com.cbt.system.mapper;

import java.util.List;

import com.cbt.system.po.ProductPlanInfo;

public interface ProductPlanInfoMapper {
	//根据生产计划查询出对应的PlanId
	public int selectIdByPlanUnit(String planunit)throws Exception;
	//插入一个新的生产计划
	public int insertNewProductPlan(ProductPlanInfo productPlanInfo)throws Exception;
	//根据Id删除生产计划
	public int deleteProductPlan(Integer planId)throws Exception;
	//query all product plan
	public List<ProductPlanInfo> queryAllProductPlan()throws Exception;
	//update by id
	public int updatePlanById(ProductPlanInfo productPlanInfo)throws Exception;
	

}

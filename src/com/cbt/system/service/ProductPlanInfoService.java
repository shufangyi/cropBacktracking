package com.cbt.system.service;

import java.util.List;

import com.cbt.system.po.ProductPlanInfo;



public interface ProductPlanInfoService{
	
	//根据生产计划查询出对应的PlanId
	public int selectIdByPlanUnitService(String planunit)throws Exception;
	//插入一个新的生产计划
	public int insertNewProductPlanService(ProductPlanInfo productPlanInfo)throws Exception;
	
	//query all product plan
	public List<ProductPlanInfo> queryAllProductPlanService()throws Exception;
	
	
	//分页查询所有生产计划
	public List<ProductPlanInfo> getPageProductPlan(int nowpage,int rows,String SearchKey) throws Exception;
	//分页记录
	public int getProductPlanInfoCount(int nowpage,int rows,String SearchKey)  throws Exception;
	//删除多个生产计划
	public Boolean delProductPlan(List<ProductPlanInfo> list) throws Exception;
	//更新单个生产计划
	public Boolean updateProductPlan(ProductPlanInfo  info) throws Exception;
	
	
	public List<ProductPlanInfo> getProductPlans();


}

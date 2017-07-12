package com.cbt.system.mapper;

import java.util.List;

import com.cbt.system.po.ProductPlanUnitInfo;

public interface ProductPlanUnitInfoMapper {
	
	//插入一个新的生产单元
	public int insertNewUnit(ProductPlanUnitInfo productPlanUnitInfo)throws Exception;
	
	//根据id删除生产单元
	public int deleteUnitById(ProductPlanUnitInfo productPlanUnitInfo) throws Exception;
	
	//query all product units
	public List<ProductPlanUnitInfo> queryAllUnit()throws Exception;
	
	
}

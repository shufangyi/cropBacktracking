package com.cbt.system.service;

import java.util.List;


import com.cbt.system.po.ProductPlanUnitInfo;


public interface ProductPlanUnitInfoService {
	//insert a new unit
	public int insertNewUnitService(ProductPlanUnitInfo productPlanUnitInfo)throws Exception;
	//delete by id
	public int deleteUnitByIdService(ProductPlanUnitInfo productPlanUnitInfo)throws Exception;
	//query all units
	public List<ProductPlanUnitInfo> queryAllUnitService()throws Exception;
	
}

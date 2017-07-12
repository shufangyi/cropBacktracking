package com.cbt.visitor.service;

import com.cbt.visitor.po.ProductStatusInfo;

public interface ProductStatusInfoService {
	//插入一条新的产品发布信息
	public void insertNewProductService(ProductStatusInfo productStatusInfo)throws Exception;
	
	//更新产品状态
	public int updateProductStatusService(ProductStatusInfo productStatusInfo)throws Exception;
	
	//修改查询次数
	public int updateQueryTimesService(ProductStatusInfo productStatusInfo) throws Exception;
	
	//删除产品信息
	public int deleteProductStatusInfoService(String product_btCode)throws Exception;

}

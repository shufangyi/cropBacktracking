package com.cbt.visitor.service;

import org.springframework.stereotype.Service;

import com.cbt.visitor.po.ProductStatusInfo;


@Service
public interface ProductStatusInfoService {
	//插入一条新的产品发布信息
	public void insertNewProductService(ProductStatusInfo productStatusInfo)throws Exception;
	
	//更新产品状态
	public int updateProductStatusService(ProductStatusInfo productStatusInfo)throws Exception;
	
	//修改查询次数
	public int updateQueryTimesService(ProductStatusInfo productStatusInfo) throws Exception;
	
	//删除产品信息
	public int deleteProductStatusInfoService(String product_btCode)throws Exception;
	
	//更新查询次数 by ZC
	public int updateQueryTimesByBtCodeService(ProductStatusInfo productStatusInfo)throws Exception;
	//查询出现在的次数 by ZC
	public int queryTimesByBtCodeService(String Product_btCode)throws Exception;
	
	
	public Boolean checkProductBtcode(String productBtcode);

}

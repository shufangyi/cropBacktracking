package com.cbt.visitor.mapper;

import java.util.List;

import com.cbt.visitor.po.ProductStatusInfo;

public interface ProductStatusInfoMapper {
	
	public void insertNewProduct(ProductStatusInfo productStatusInfo)throws Exception;
	public int updateProductStatus(ProductStatusInfo productStatusInfo)throws Exception;
	public int updateQueryTimes(ProductStatusInfo productStatusInfo)throws Exception;
	public int  deleteProductStatusInfo(String product_btCode)throws Exception;
	//更新查询次数 by ZC
	public int updateQueryTimesByBtCode(ProductStatusInfo productStatusInfo)throws Exception;
	//通过btCode查询出现在的次数
	public int queryTimesByBtCode(String product_btCode)throws Exception;
	
	
	
	public int getProductStatusInfo(String product_btCode);

	
	public List<ProductStatusInfo> getData(String businessId);
}

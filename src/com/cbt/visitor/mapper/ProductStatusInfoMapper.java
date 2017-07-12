package com.cbt.visitor.mapper;

import com.cbt.visitor.po.ProductStatusInfo;

public interface ProductStatusInfoMapper {
	
	public void insertNewProduct(ProductStatusInfo productStatusInfo)throws Exception;
	public int updateProductStatus(ProductStatusInfo productStatusInfo)throws Exception;
	public int updateQueryTimes(ProductStatusInfo productStatusInfo)throws Exception;
	public int  deleteProductStatusInfo(String product_btCode)throws Exception;

}

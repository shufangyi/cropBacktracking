package com.cbt.visitor.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbt.visitor.mapper.*;
import com.cbt.visitor.po.ProductStatusInfo;
import com.cbt.visitor.service.ProductStatusInfoService;

@Service
public class ProductStatusInfoServiceImpl implements ProductStatusInfoService {
	@Autowired
	private ProductStatusInfoMapper productStatusInfoMapper;

	@Override
	public void insertNewProductService(com.cbt.visitor.po.ProductStatusInfo product) throws Exception {
		// TODO Auto-generated method stub
		productStatusInfoMapper.insertNewProduct(product);
		
	}
	@Override
	public int updateProductStatusService(com.cbt.visitor.po.ProductStatusInfo product) throws Exception {
		// TODO Auto-generated method stub
		return productStatusInfoMapper.updateProductStatus(product);
	}

	@Override
	public int updateQueryTimesService(com.cbt.visitor.po.ProductStatusInfo product) throws Exception {
		// TODO Auto-generated method stub
		return productStatusInfoMapper.updateQueryTimes(product);
	}

	@Override
	public int deleteProductStatusInfoService(String product_btCode) throws Exception {
		// TODO Auto-generated method stub
		return productStatusInfoMapper.deleteProductStatusInfo(product_btCode);
	}
	//更新查询次数by溯源码25位
	@Override
	public int updateQueryTimesByBtCodeService(ProductStatusInfo productStatusInfo) throws Exception {
		return productStatusInfoMapper.updateQueryTimesByBtCode(productStatusInfo);
	}
	@Override
	public int queryTimesByBtCodeService(String Product_btCode) throws Exception {
		return productStatusInfoMapper.queryTimesByBtCode(Product_btCode);
	}
	
	
	@Override
	public Boolean checkProductBtcode(String productBtcode) {
		// TODO Auto-generated method stub
		Boolean mark = false;
		System.out.println(productBtcode);
		int c = productStatusInfoMapper.getProductStatusInfo(productBtcode);
		if(c>=0)
			mark=true;
		return mark;
	}
	@Override
	public HashMap<String,Integer> getData(String businessId) {
		// TODO Auto-generated method stub
		List<ProductStatusInfo> list = productStatusInfoMapper.getData(businessId);
		HashMap<String,Integer> map = new HashMap<String,Integer>(); 
		for(int i = 0 ; i < list.size();i++)
		{
			String key = list.get(i).getProduct_btCode();
			key = key.substring(0, 9);
			int value = list.get(i).getQueryTimes();
			if(map.get(key)==null)
			{
				map.put(key,value);
			}
			else
			{
				map.put(key, map.get(key)+value);
			}
		}
		return map;
	}
}

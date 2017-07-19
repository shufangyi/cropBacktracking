package com.cbt.system.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbt.system.mapper.ProductPlanInfoMapper;
import com.cbt.system.po.ProductPlanInfo;


@Service
public class ProductPlanInfoServiceImpl implements com.cbt.system.service.ProductPlanInfoService {

	
	@Autowired
	private ProductPlanInfoMapper productPlanInfoMapper;
	
	//根据生产计划查询出对应的PlanId
	@Override
	public int selectIdByPlanUnitService(String planunit) throws Exception {
		// TODO Auto-generated method stub
		return productPlanInfoMapper.selectIdByPlanUnit(planunit);
	}
	//插入一个新的生产计划
	@Override
	public int insertNewProductPlanService(ProductPlanInfo productPlanInfo) throws Exception {
		// TODO Auto-generated method stub
		return productPlanInfoMapper.insertNewProductPlan(productPlanInfo);

	}
	
	//query all product plan
	@Override
	public List<ProductPlanInfo> queryAllProductPlanService() throws Exception {
		// TODO Auto-generated method stub
		return productPlanInfoMapper.queryAllProductPlan();
	}
	
	/*记录数据个数*/
	@Override
	public int getProductPlanInfoCount() throws Exception {
		// TODO Auto-generated method stub
		return productPlanInfoMapper.getProductPlanInfoCount();
	}
	/*分页查询数据*/
	@Override
	public List<ProductPlanInfo> getPageProductPlan(int nowpage, int rows) throws Exception  {
		// TODO Auto-generated method stub
		int startrow=(nowpage-1)*rows;
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("startrow",startrow);
		map.put("rows", rows);   
		return  productPlanInfoMapper.getPageProductPlanInfo(map);
	}
	
	/*删除多个生产计划数据*/
	@Override
	public Boolean delProductPlan(List<ProductPlanInfo> list) throws Exception {
		// TODO Auto-generated method stub
		for(int i=0;i<list.size();i++)
		{
			if(productPlanInfoMapper.deleteProductPlan(list.get(i))<0)
				return false;
		}
		return true;
	}
	
	
	/*更新生产计划数据*/
	@Override
	public Boolean updateProductPlan(ProductPlanInfo info) throws Exception {
		// TODO Auto-generated method stub
		try{
			if(productPlanInfoMapper.updatePlanById(info)>0)
				return true;
		}catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<ProductPlanInfo> getProductPlans() {
		// TODO Auto-generated method stub
		return productPlanInfoMapper.getProductPlans();
	}

}

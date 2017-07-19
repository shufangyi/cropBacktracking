package com.cbt.business.service;

import java.util.List;

import com.cbt.business.po.BusinessProjectPlanInfo;

public interface BusinessProjectPlanInfoService {


	public Boolean addBusinessProjectPlan(BusinessProjectPlanInfo info);	
	
	
	public List<BusinessProjectPlanInfo> getPageBusinessProjectPlans(int nowpage, int rows , int businessId);
	
	public int getBusinessProjectPlansCount(int businessId);
	
	
	public Boolean updateBusinessProjectPlan(BusinessProjectPlanInfo info);
	
	//删除数据
	Boolean delBusinessProjectPlan(List<BusinessProjectPlanInfo> list);
}

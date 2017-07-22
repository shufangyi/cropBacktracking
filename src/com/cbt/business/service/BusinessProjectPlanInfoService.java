package com.cbt.business.service;

import java.util.List;

import com.cbt.business.po.BusinessProjectPlanInfo;

public interface BusinessProjectPlanInfoService {


	public Boolean addBusinessProjectPlan(BusinessProjectPlanInfo info);	
	
	
	public List<BusinessProjectPlanInfo> getPageBusinessProjectPlans(int nowpage, int rows , int businessId,String searchKey);
	
	public int getBusinessProjectPlansCount(int businessId,String searchKey);
	
	
	public Boolean updateBusinessProjectPlan(BusinessProjectPlanInfo info);
	
	//删除数据
	Boolean delBusinessProjectPlan(List<BusinessProjectPlanInfo> list);
	
	public List<BusinessProjectPlanInfo> getProjectInfos(String businessId);
	
	public Boolean insertProductPictureByProject_btCode(String project_btCode,String productPicture);
}

package com.cbt.business.mapper;

import java.util.List;
import java.util.Map;

import com.cbt.business.po.BusinessProjectPlanInfo;

public interface BusinessProjectPlanInfoMapper
{	
	public int addBusinessProjectPlan(BusinessProjectPlanInfo info);
	//2017 - 7 -16
	/*分页查询*/
	public List<BusinessProjectPlanInfo> getPageBusinessProjectPlans(Map<String,Object> map);
	/*分页记录*/
	public int getBusinessProjectPlansCount(Map<String,Object> map);	
	//修改数据
	public int updateBusinessProjectPlan(BusinessProjectPlanInfo info);
	//删除数据
	public int delBusinessProjectPlan(BusinessProjectPlanInfo info);

}

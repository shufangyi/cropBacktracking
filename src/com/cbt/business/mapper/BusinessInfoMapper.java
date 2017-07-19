package com.cbt.business.mapper;

import java.util.List;
import java.util.Map;

import com.cbt.business.po.BusinessCropProjectInfo;
import com.cbt.business.po.BusinessInfo;

public interface BusinessInfoMapper
{
	/*查询所有信息*/
	public List<BusinessInfo> getAllBusinessInfo();
	/*查询一条信息*/
	public BusinessInfo  getBusinessInfo(BusinessInfo info);
	/*增加一条数据*/
	public int addBusinessInfo(BusinessInfo info);
	/*删除一条数据*/
	public int delBusinessInfo(BusinessInfo info);
	
	public List<BusinessInfo> getPageBusinesss(Map<String,Object> map);
	
	public int getBusinesssCount();
	
	public int updateBusiness(BusinessInfo info);
	
	
}

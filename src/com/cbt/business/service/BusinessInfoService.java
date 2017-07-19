package com.cbt.business.service;

import java.util.List;

import com.cbt.business.po.BusinessInfo;

public interface BusinessInfoService {
	/*查询所有信息*/
	public List<BusinessInfo> getAllBusinessInfo();
	/*查询一条信息*/
	public BusinessInfo  getBusinessInfo(BusinessInfo info);
	/*增加一条数据*/
	public Boolean addBusiness(BusinessInfo info);
	/*删除一条数据*/
	public Boolean delBusiness(List<BusinessInfo> list);
	

	
	
	
	public List<BusinessInfo> getPageBusinesss(int nowpage, int rows);
	
	public int getBusinesssCount();
	
	
	public Boolean updateBusiness(BusinessInfo info);

}

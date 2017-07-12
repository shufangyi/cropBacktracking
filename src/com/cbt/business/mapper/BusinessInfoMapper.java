package com.cbt.business.mapper;

import java.util.List;

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
}

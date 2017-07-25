package com.cbt.business.mapper;

import java.util.List;

import com.cbt.business.po.BusinessCropProjectInfo;

public interface BusinessCropProjectInfoMapper {
	/*查询一条数据*/
	public List<BusinessCropProjectInfo> getBusinessCropProjectInfo(BusinessCropProjectInfo info);
	/*查询所有数据*/
	public List<BusinessCropProjectInfo> getAllBusinessCropProjectInfo();
	/*增加一条数据*/
	public int addBusinessCropProjectInfo(BusinessCropProjectInfo info);
	/*删除一条数据*/
	public int delBusinessCropProjectInfo(BusinessCropProjectInfo info);
	
	
	public List<BusinessCropProjectInfo> getInfoByProjectBtCode(String project_btCode);
	
}

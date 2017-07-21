package com.cbt.business.service;

import java.util.List;

import com.cbt.business.po.CropBackPicInfo;

public interface CropBackPicInfoService 
{
	public Boolean saveCropBackPicInfo(CropBackPicInfo info);
	//delete by projectCode
	public int deleteByProjectCodeService(CropBackPicInfo info)throws Exception;
	
	public List<CropBackPicInfo> getCropBackPicInfoByProjectCode(String projectCode);
}

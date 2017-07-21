package com.cbt.business.mapper;

import java.util.List;

import com.cbt.business.po.CropBackPicInfo;

public interface CropBackPicInfoMapper {
	public int saveCropBackPicInfo(CropBackPicInfo info);
	//删除图片
	public int deleteByProjectCode(CropBackPicInfo info);
	
	//根据回去图片
	public List<CropBackPicInfo> getCropBackPicInfoByProjectCode(String projectCode);
}

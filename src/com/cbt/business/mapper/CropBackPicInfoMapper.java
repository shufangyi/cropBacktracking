package com.cbt.business.mapper;

import com.cbt.business.po.CropBackPicInfo;

public interface CropBackPicInfoMapper {
	public int saveCropBackPicInfo(CropBackPicInfo info);
	//删除图片
	public int deleteByProjectCode(CropBackPicInfo info);
}

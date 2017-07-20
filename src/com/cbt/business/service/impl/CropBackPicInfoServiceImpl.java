package com.cbt.business.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cbt.business.mapper.CropBackPicInfoMapper;
import com.cbt.business.po.CropBackPicInfo;
import com.cbt.business.service.CropBackPicInfoService;


@Service
public class CropBackPicInfoServiceImpl implements CropBackPicInfoService{

	@Resource(name="cropBackPicInfoMapper")
	private CropBackPicInfoMapper cropBackPicInfoMapper;
	
	@Override
	public Boolean saveCropBackPicInfo(CropBackPicInfo info) {
		// TODO Auto-generated method stub
		int i = cropBackPicInfoMapper.saveCropBackPicInfo(info);
		if(i>0)
			return true;
		else
			return false;
	}

}

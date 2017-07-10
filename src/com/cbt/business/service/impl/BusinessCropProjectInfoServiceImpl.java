package com.cbt.business.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cbt.business.mapper.BusinessCropProjectInfoMapper;
import com.cbt.business.po.BusinessCropProjectInfo;
import com.cbt.business.service.BusinessCropProjectInfoService;

@Service
public class BusinessCropProjectInfoServiceImpl implements BusinessCropProjectInfoService{
	
	@Resource(name="businessCropProjectInfoMapper")
	private BusinessCropProjectInfoMapper businessCropProjectInfoMapper;
	
	@Override
	public BusinessCropProjectInfo getBusinessCropProjectInfo(BusinessCropProjectInfo info) {
		// TODO Auto-generated method stub
		System.out.println("hello impl");
		return businessCropProjectInfoMapper.getBusinessCropProjectInfo(info);
	}

}

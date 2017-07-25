package com.cbt.business.service.impl;

import java.util.List;

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
	public List<BusinessCropProjectInfo> getBusinessCropProjectInfo(BusinessCropProjectInfo info) {
		// TODO Auto-generated method stub
		System.out.println("hello impl");
		return businessCropProjectInfoMapper.getBusinessCropProjectInfo(info);
	}

	@Override
	public List<BusinessCropProjectInfo> getAllBusinessCropProjectInfo() {
		// TODO Auto-generated method stub
		return businessCropProjectInfoMapper.getAllBusinessCropProjectInfo();
	}

	@Override
	public int addBusinessCropProjectInfo(BusinessCropProjectInfo info) {
		// TODO Auto-generated method stub
		return businessCropProjectInfoMapper.addBusinessCropProjectInfo(info);
	}

	@Override
	public int delBusinessCropProjectInfo(BusinessCropProjectInfo info) {
		// TODO Auto-generated method stub
		return businessCropProjectInfoMapper.delBusinessCropProjectInfo(info);
	}

	@Override
	public List<BusinessCropProjectInfo> getInfoByProjectBtCode(String project_btCode) {
		// TODO Auto-generated method stub
		return businessCropProjectInfoMapper.getInfoByProjectBtCode(project_btCode);
	}

}

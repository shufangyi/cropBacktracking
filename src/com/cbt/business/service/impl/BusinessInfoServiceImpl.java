package com.cbt.business.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cbt.business.mapper.BusinessInfoMapper;
import com.cbt.business.po.BusinessInfo;
import com.cbt.business.service.BusinessInfoService;

@Service
public class BusinessInfoServiceImpl implements BusinessInfoService{

	@Resource(name="businessInfoMapper")
	private BusinessInfoMapper businessInfoMapper;
	
	@Override
	public List<BusinessInfo> getAllBusinessInfo() {
		// TODO Auto-generated method stub
		
		return businessInfoMapper.getAllBusinessInfo();
	}



	@Override
	public BusinessInfo getBusinessInfo(BusinessInfo info) {
		// TODO Auto-generated method stub
		return businessInfoMapper.getBusinessInfo(info);
	}



	@Override
	public int addBusinessInfo(BusinessInfo info) {
		// TODO Auto-generated method stub
		return businessInfoMapper.addBusinessInfo(info);
	}



	@Override
	public int delBusinessInfo(BusinessInfo info) {
		// TODO Auto-generated method stub
		return businessInfoMapper.delBusinessInfo(info);
	}

}

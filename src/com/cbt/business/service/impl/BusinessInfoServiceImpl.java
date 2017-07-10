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

}

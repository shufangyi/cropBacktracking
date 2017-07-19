package com.cbt.business.service.impl;

import java.util.HashMap;
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
	public Boolean addBusiness(BusinessInfo info) {
		// TODO Auto-generated method stub
		int i = businessInfoMapper.addBusinessInfo(info);
		if(i > 0 )
			return true;
		return false;
	}



	@Override
	public Boolean delBusiness(List<BusinessInfo> list) {
		// TODO Auto-generated method stub
		Boolean mark = true;
		for(int i=0;i<list.size();i++)
		{
			int k = businessInfoMapper.delBusinessInfo(list.get(i));
			if(i<=0){
				return false;
			}
		}
		return true;
	}



	@Override
	public List<BusinessInfo> getPageBusinesss(int nowpage, int rows) {
		// TODO Auto-generated method stub
		int startrow=(nowpage-1)*rows;
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("startrow",startrow);
		map.put("rows", rows);   
		return businessInfoMapper.getPageBusinesss(map);
	}



	@Override
	public int getBusinesssCount() {
		// TODO Auto-generated method stub
		return businessInfoMapper.getBusinesssCount();
	}



	@Override
	public Boolean updateBusiness(BusinessInfo info) {
		// TODO Auto-generated method stub
		try {
			int i = businessInfoMapper.updateBusiness(info);
			if(i>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}

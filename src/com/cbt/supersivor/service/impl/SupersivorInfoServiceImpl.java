package com.cbt.supersivor.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cbt.supersivor.mapper.SupersivorInfoMapper;
import com.cbt.supersivor.po.SupersivorInfo;
import com.cbt.supersivor.service.SupersivorInfoService;


@Service
public class SupersivorInfoServiceImpl implements SupersivorInfoService
{
	@Resource(name="supersivorInfoMapper")
	private SupersivorInfoMapper supersivorInfoMapper;
	
	@Override
	public SupersivorInfo getSupersivorInfo(SupersivorInfo info) {
		// TODO Auto-generated method stub
		return supersivorInfoMapper.getSupersivorInfo(info);
	}

}

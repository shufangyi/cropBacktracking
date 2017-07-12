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

	//查询验证密码,返回查询的密码包装类
	@Override
	public SupersivorInfo queryPwdByNum(SupersivorInfo supersivorInfo) throws Exception {
		// TODO Auto-generated method stub
		return supersivorInfoMapper.queryPwdByNum(supersivorInfo);
	}

	//insert a new supersivorNum
	@Override
	public int insertSupersivor(SupersivorInfo supersivorInfo) throws Exception {
		// TODO Auto-generated method stub
		return supersivorInfoMapper.insertSupersivor(supersivorInfo);
	}

	//update password
	@Override
	public int updateSupersivorPwd(SupersivorInfo supersivorInfo) throws Exception {
		// TODO Auto-generated method stub
		return supersivorInfoMapper.updateSupersivorPwd(supersivorInfo);
	}

}

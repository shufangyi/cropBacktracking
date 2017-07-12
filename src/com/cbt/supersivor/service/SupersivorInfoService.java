package com.cbt.supersivor.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.cbt.supersivor.mapper.SupersivorInfoMapper;
import com.cbt.supersivor.po.SupersivorInfo;

public interface SupersivorInfoService {
	//查询验证密码
	public SupersivorInfo queryPwdByNum(SupersivorInfo supersivorInfo)throws Exception;
	
	//inert a new supersivorNum
	public int insertSupersivor(SupersivorInfo supersivorInfo)throws Exception;
	//修改密码
	public int updateSupersivorPwd(SupersivorInfo supersivorInfo)throws Exception;
	
	
	public SupersivorInfo getSupersivorInfo(SupersivorInfo info);
}

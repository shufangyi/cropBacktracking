package com.cbt.supersivor.mapper;

import java.util.List;

import com.cbt.supersivor.po.SupersivorInfo;

public interface SupersivorInfoMapper {
	//查询验证密码
	public SupersivorInfo queryPwdByNum(SupersivorInfo supersivorInfo)throws Exception;
	//insert a new supersivorNum
	public int insertSupersivor(SupersivorInfo supersivorInfo)throws Exception;
	//修改密码
	public int updateSupersivorPwd(SupersivorInfo supersivorInfo)throws Exception;
	

	public SupersivorInfo getSupersivorInfo(SupersivorInfo info);
}

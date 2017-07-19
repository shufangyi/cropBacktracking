package com.cbt.system.service;

import java.util.List;

import com.cbt.system.po.CropcodeInfo;

public interface CropcodeInfoService {
	/* 分页查询数据*/
	public List<CropcodeInfo> getPageCropcodeInfo(int nowpage, int rows);
	/* 获取数据的个数*/
	public int getRecordsCount();

}

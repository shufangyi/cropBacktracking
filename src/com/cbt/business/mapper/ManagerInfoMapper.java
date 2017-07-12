package com.cbt.business.mapper;

import java.util.List;

import com.cbt.system.po.ManagerInfo;



public interface ManagerInfoMapper {
	/*查询一条数据*/
	public ManagerInfo getManagerInfo(ManagerInfo info);
	/*查询所有数据*/
	public List<ManagerInfo> getAllManagerInfo();
	/*增加一条数据*/
	public int addManagerInfo(ManagerInfo info);
	/*删除一条数据*/
	public int delManagerInfo(ManagerInfo info);

}

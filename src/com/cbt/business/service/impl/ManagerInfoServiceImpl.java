package com.cbt.business.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cbt.business.mapper.ManagerInfoMapper;
import com.cbt.business.service.ManagerInfoService;
import com.cbt.system.po.ManagerInfo;

@Service
public class ManagerInfoServiceImpl implements ManagerInfoService{

	@Resource(name="managerInfoMapper")
	private ManagerInfoMapper managerInfoMapper;
	@Override
	public ManagerInfo getManagerInfo(ManagerInfo info) {
		// TODO Auto-generated method stub
		return managerInfoMapper.getManagerInfo(info);
	}

	@Override
	public List<ManagerInfo> getAllManagerInfo() {
		// TODO Auto-generated method stub
		return managerInfoMapper.getAllManagerInfo();
	}

	@Override
	public boolean addManager(ManagerInfo info) {
		// TODO Auto-generated method stub
		int i = managerInfoMapper.addManagerInfo(info);
		if(i > 0 )
			return true;
		return false;
	}

	@Override
	public Boolean delManager(List<ManagerInfo> list) {
		// TODO Auto-generated method stub
		Boolean mark = true;
		for(int i=0;i<list.size();i++)
		{
			int k = managerInfoMapper.delManagerInfo(list.get(i));
			if(i<=0){
				return false;
			}
		}
		return true;
	}

	@Override
	public List<ManagerInfo> getPageManagers(int nowpage, int rows) {
		// TODO Auto-generated method stub
		int startrow=(nowpage-1)*rows;
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("startrow",startrow);
		map.put("rows", rows);   
		return managerInfoMapper.getPageManagers(map);
	}

	@Override
	public int getManagersCount() {
		// TODO Auto-generated method stub
		return managerInfoMapper.getManagersCount();
	}

	@Override
	public Boolean updateManager(ManagerInfo info) {
		// TODO Auto-generated method stub
		try {
			int i = managerInfoMapper.updateManager(info);
			if(i>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}

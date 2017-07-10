package com.cbt.system.po;

import java.util.ArrayList;
//���ƻ�
public class ProductPlanInfo
{
	private String ppName;//���ƻ����
	private ArrayList<ProductPlanUnitInfo> ppuList;//���ƻ���Ԫ�б�

	public ArrayList<ProductPlanUnitInfo> getPpuList() {
		return ppuList;
	}

	public void setPpuList(ArrayList<ProductPlanUnitInfo> ppList) {
		this.ppuList = ppList;
	}
	
	public String getPpName() {
		return ppName;
	}

	public void setPpName(String ppName) {
		this.ppName = ppName;
	}
	
	public String toString()
	{
		String res = "";
		for(int i=0;i<ppuList.size();i++)
		{
			res+=ppuList.get(i).getPpuName();
		}
		return res;
	}
}

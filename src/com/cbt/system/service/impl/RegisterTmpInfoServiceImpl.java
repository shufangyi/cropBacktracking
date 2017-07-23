package com.cbt.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.commons.mail.EmailException;
import org.springframework.stereotype.Service;

import com.cbt.business.po.BusinessInfo;
import com.cbt.business.service.BusinessInfoService;
import com.cbt.business.service.ManagerInfoService;
import com.cbt.system.mapper.RegisterTmpInfoMapper;
import com.cbt.system.po.ManagerInfo;
import com.cbt.system.po.RegisterTmpInfo;
import com.cbt.system.service.RegisterTmpInfoService;
import com.cbt.utils.Mutil;
import com.cbt.utils.PathConfig;


@Service
public class RegisterTmpInfoServiceImpl implements RegisterTmpInfoService{

	@Resource(name="pathConfig")
	private PathConfig pathConfig;
	
	@Resource(name="registerTmpInfoMapper")
	private RegisterTmpInfoMapper registerTmpInfoMapper;
	
	
	@Resource(name="managerInfoServiceImpl")
	private ManagerInfoService managerInfoService;
	
	@Resource(name="businessInfoServiceImpl")
	private BusinessInfoService businessInfoService;
	
	@Override
	public Boolean deleteRegisterTmpInfo(List<RegisterTmpInfo> list) {
		// TODO Auto-generated method stub
		for(int i=0;i<list.size();i++)
		{
			int k = registerTmpInfoMapper.deleteRegisterTmpInfo(list.get(i));
			if(k<=0){
				return false;
			}
		}
		return true;
	}

	@Override
	public List<RegisterTmpInfo> getPageRegisters(int startpage, int rows, String status) {
		// TODO Auto-generated method stub
		HashMap<String,Object> map = new HashMap<String,Object>();
		startpage=(startpage-1)*rows;
		map.put("startrow",startpage);
		map.put("rows",rows);
		map.put("status", status);
		return registerTmpInfoMapper.getPageRegisters(map);
	}

	@Override
	public int getPageRegisterCount(String status) {
		// TODO Auto-generated method stub
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("status", status);
		
		
		return registerTmpInfoMapper.getPageRegisterCount(map);
	}

	/*
	 * 将信息保存到其他两个表中managerInfoService，businessInfoService
	 * 发送邮件
	 */
	@Override
	public Boolean rejectRegister(List<RegisterTmpInfo> list) {
		// TODO Auto-generated method stub
		
		Mutil mutil = new Mutil();
		
		String fromemail = pathConfig.getEmailNum();
		String frompassword = pathConfig.getEmailPwd();
		String subject = pathConfig.getEmailSubject();
		String link = pathConfig.getEmailLink();
		
		for(int i=0;i<list.size();i++)
		{
			RegisterTmpInfo rinfo = list.get(i);
			String toemail = rinfo.getManagerEmail();
			
			
			int k = registerTmpInfoMapper.rejectRegister(rinfo);
			if(k<=0){
				return false;
			}
			try{
				String content = "您的注册未通过！";
				mutil.send(fromemail, frompassword, toemail, subject, content);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("邮件发送失败");
			}
			
		}
		return true;
	}

		
	/*
	 *发送邮件
	 * 将信息保存到其他两个表中managerInfoService，businessInfoService
	 */
	@Override
	public Boolean allowRegister(List<RegisterTmpInfo> list)
	{
		//邮件信息
		Mutil mutil = new Mutil();
		
		String fromemail = pathConfig.getEmailNum();
		String frompassword = pathConfig.getEmailPwd();
		String subject = pathConfig.getEmailSubject();
		String link = pathConfig.getEmailLink();
		
		
		Boolean mark = false;
		for(int i=0;i<list.size();i++)
		{
			
			RegisterTmpInfo rinfo = list.get(i);
			BusinessInfo binfo = new BusinessInfo();
			ManagerInfo minfo = new ManagerInfo();
			
			String businessName = rinfo.getBusinessName();
			String managerName = rinfo.getManagerName();
			String managerNum = rinfo.getManagerNum();
			String managerPwd = rinfo.getManagerPwd();
			String managerEmail = rinfo.getManagerEmail();
			String managerPhone = rinfo.getManagerPhone();

			//生成businessId,唯一
			Random random = new Random();  
	        int businessId = (int) (random.nextDouble() * (999 - 100 + 1)) + 100;// 获取3位随机数  
	        System.out.println("三位随机数:"+businessId);
	        binfo.setBusinessId(businessId+"");
	        if(businessInfoService.getBusinessInfo(binfo)!=null)
	        {
	        	businessId = (int) (random.nextDouble() * (999 - 100 + 1)) + 100;// 获取3位随机数  
	        	System.out.println("三位随机数:"+businessId);
				
	        	binfo.setBusinessId(businessId+"");
	        }
	        binfo.setBusinessName(businessName);
			minfo.setBusinessId(businessId);
			minfo.setBusinessName(businessName);
			minfo.setManagerEmail(managerEmail);
			minfo.setManagerName(managerName);
			minfo.setManagerPwd(managerPwd);
			minfo.setManagerNum(managerNum);
			minfo.setManagerPhone(managerPhone);
			

			int k = registerTmpInfoMapper.allowRegister(rinfo);
			if(k<=0){
				return false;
			}			
			mark=businessInfoService.addBusiness(binfo);
			if(mark==false)
				return false;
			mark=managerInfoService.addManager(minfo);
			if(mark==false)
				return false;

			//调用邮件发送
			String toemail = rinfo.getManagerEmail();
			String content = "使用您注册时所填填写的帐号与密码进行登录！网址"+link+"!公司编号为:"+businessId;
			try{
				mutil.send(fromemail, frompassword, toemail, subject, content);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("邮件发送失败");
			}
		}
		return mark;
	}

	
	@Override
	public Boolean addRegisterTmpInfo(RegisterTmpInfo info) {
		// TODO Auto-generated method stub
		int i = registerTmpInfoMapper.addRegisterTmpInfo(info);
		if(i>0)
			return true;
		return false;
	}

}

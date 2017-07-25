package com.cbt.business.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cbt.business.po.BusinessCropProjectInfo;
import com.cbt.business.po.WorkerInfo;
import com.cbt.business.service.BusinessCropProjectInfoService;
import com.cbt.business.service.WorkerInfoService;
import com.cbt.system.po.RegisterTmpInfo;
import com.cbt.utils.Mutil;
import com.cbt.utils.PathConfig;

@Controller
@RequestMapping("/business/")
public class BusinessCropProjectInfoController 
{
	
	@Resource(name="businessCropProjectInfoServiceImpl")
	private BusinessCropProjectInfoService businessCropProjectInfoService;
	
	@Resource(name="workerInfoServiceImpl")
	private WorkerInfoService workerInfoService;
	
	@Resource(name="pathConfig")
	private PathConfig pathConfig;
	
	@RequestMapping("sendPlanEmail.do")
	public @ResponseBody String sendPlanEmail(String project_btCode)
	{
		Boolean mark=true;
		Mutil mutil = new Mutil();
		System.out.println("项目编码"+project_btCode);
		//service方法
		List<BusinessCropProjectInfo> list = businessCropProjectInfoService.getInfoByProjectBtCode(project_btCode);
		System.out.println("size:"+list.size());
		for(int i=0;i<list.size();i++)
		{
			int workerId = list.get(i).getWorkerId();
			//通过workerId查询workerInfo表
			//获取
			WorkerInfo winfo =  workerInfoService.getWorkerInfoByWorkerId(workerId);
			String toemail = winfo.getWorkerEmail();
			
			String fromemail = pathConfig.getEmailNum();
			String frompassword = pathConfig.getEmailPwd();
			String subject = "公司任务通知";
			String content = "你被指定参与了项目编码为： "+project_btCode+" 的计划";
			try{
				mutil.send(fromemail, frompassword, toemail, subject, content);
				System.out.println("发送成功！");
			}
			catch(Exception e)
			{
				mark = false;
				System.out.println("邮件发送失败");
			}
			
			//使用邮件接口
		}
		return mark.toString();
	}
	
	
	
	@RequestMapping("sendPickTaskEmail.do")
	public @ResponseBody String sendPickTaskEmail(String sowsegBtcode)
	{
		Boolean mark=true;
		Mutil mutil = new Mutil();
		System.out.println("种植溯源码编码"+sowsegBtcode);
		String project_btCode = sowsegBtcode.substring(0,9);
		//service方法
		List<BusinessCropProjectInfo> list = businessCropProjectInfoService.getInfoByProjectBtCode(project_btCode);
		for(int i=0;i<list.size();i++)
		{
			int workerId = list.get(i).getWorkerId();
			//通过workerId查询workerInfo表
			//获取
			WorkerInfo winfo =  workerInfoService.getWorkerInfoByWorkerId(workerId);
			String toemail = winfo.getWorkerEmail();
			
			String fromemail = pathConfig.getEmailNum();
			String frompassword = pathConfig.getEmailPwd();
			String subject = "公司任务通知";
			String content = "你被指定参与了项目编码为： "+project_btCode+" 的计划,目前进入采摘环节,采摘环节产品输入的上一环节-"
					+ "种植溯源码为： "+sowsegBtcode+"请相关人员登录系统完善信息";
			try{
				mutil.send(fromemail, frompassword, toemail, subject, content);
			}
			catch(Exception e)
			{
				mark = false;
				System.out.println("邮件发送失败");
			}
			
			//使用邮件接口
		}
		return mark.toString();
	}
	
	
	@RequestMapping("sendCheckInTaskEmail.do")
	public @ResponseBody String sendCheckInTaskEmail(String picksegBtcode)
	{
		Boolean mark=true;
		Mutil mutil = new Mutil();
		System.out.println("采摘溯源码编码"+picksegBtcode);
		String project_btCode = picksegBtcode.substring(0,9);
		//service方法
		List<BusinessCropProjectInfo> list = businessCropProjectInfoService.getInfoByProjectBtCode(project_btCode);
		for(int i=0;i<list.size();i++)
		{
			int workerId = list.get(i).getWorkerId();
			//通过workerId查询workerInfo表
			//获取
			WorkerInfo winfo =  workerInfoService.getWorkerInfoByWorkerId(workerId);
			String toemail = winfo.getWorkerEmail();
			
			String fromemail = pathConfig.getEmailNum();
			String frompassword = pathConfig.getEmailPwd();
			String subject = "公司任务通知";
			String content = "你被指定参与了项目编码为： "+project_btCode+" 的计划,目前进入入库环节,入库环节产品输入的上一环节"
					+ "采摘溯源码为： "+picksegBtcode+"请相关人员登录系统完善信息";
			try{
				mutil.send(fromemail, frompassword, toemail, subject, content);
			}
			catch(Exception e)
			{
				mark = false;
				System.out.println("邮件发送失败");
			}
			
			//使用邮件接口
		}
		return mark.toString();
	}
	
	@RequestMapping("sendCopackTaskEmail.do")
	public @ResponseBody String sendCopackTaskEmail(String checkinsegBtcode)
	{
		Boolean mark=true;
		Mutil mutil = new Mutil();
		System.out.println("入库溯源码编码"+checkinsegBtcode);
		String project_btCode = checkinsegBtcode.substring(0,9);
		//service方法
		List<BusinessCropProjectInfo> list = businessCropProjectInfoService.getInfoByProjectBtCode(project_btCode);
		for(int i=0;i<list.size();i++)
		{
			int workerId = list.get(i).getWorkerId();
			//通过workerId查询workerInfo表
			//获取
			WorkerInfo winfo =  workerInfoService.getWorkerInfoByWorkerId(workerId);
			String toemail = winfo.getWorkerEmail();
			
			String fromemail = pathConfig.getEmailNum();
			String frompassword = pathConfig.getEmailPwd();
			String subject = "公司任务通知";
			String content = "你被指定参与了项目编码为： "+project_btCode+" 的计划,目前进入包装环节,入库环节产品输入的上一环节"
					+ "入库溯源码为： "+checkinsegBtcode+"请相关人员登录系统完善信息";
			try{
				mutil.send(fromemail, frompassword, toemail, subject, content);
			}
			catch(Exception e)
			{
				mark = false;
				System.out.println("邮件发送失败");
			}
			
			//使用邮件接口
		}
		return mark.toString();
	}
	
	
	//进入包装环节，productBtcode与订单号
	
	
	@RequestMapping("sendDeliverTaskEmail.do")
	public @ResponseBody String sendDeliverTaskEmail(String productBtcode,String ordernum)
	{
		Boolean mark=true;
		Mutil mutil = new Mutil();
		System.out.println("产品溯源码编码"+productBtcode);
		String project_btCode = productBtcode.substring(0,9);
		//service方法
		List<BusinessCropProjectInfo> list = businessCropProjectInfoService.getInfoByProjectBtCode(project_btCode);
		for(int i=0;i<list.size();i++)
		{
			int workerId = list.get(i).getWorkerId();
			//通过workerId查询workerInfo表
			//获取
			WorkerInfo winfo =  workerInfoService.getWorkerInfoByWorkerId(workerId);
			String toemail = winfo.getWorkerEmail();
			
			String fromemail = pathConfig.getEmailNum();
			String frompassword = pathConfig.getEmailPwd();
			String subject = "公司任务通知";
			String content = "你被指定参与了项目编码为： "+project_btCode+" 的计划,目前进入物流环节,入库环节产品输入的上一环节"
					+ "包装产品溯源码为： "+productBtcode+"请发货负责人与分销商用户及时登录系统发货收货信息.订单号是："+ordernum+"   .";
			try{
				mutil.send(fromemail, frompassword, toemail, subject, content);
			}
			catch(Exception e)
			{
				mark = false;
				System.out.println("邮件发送失败");
			}
			
			//使用邮件接口
		}
		return mark.toString();
	}
	
	

	
	
	
	
	
}

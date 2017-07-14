package com.cbt.business.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cbt.business.po.BusinessCropProjectInfo;
import com.cbt.business.po.MenuInfo;
import com.cbt.business.po.UserInfo;
import com.cbt.business.po.WorkerInfo;
import com.cbt.business.service.BusinessCropProjectInfoService;
import com.cbt.business.service.ManagerInfoService;
import com.cbt.business.service.MenuInfoService;
import com.cbt.business.service.WorkerInfoService;
import com.cbt.system.po.AuthorityInfo;
import com.cbt.system.po.ManagerInfo;
import com.cbt.system.po.RoleInfo;
import com.cbt.system.service.AuthorityInfoService;
import com.cbt.system.service.RoleInfoService;

@Controller
@RequestMapping("/business/")
public class UserInfoController
{
	
	@Resource(name="workerInfoServiceImpl")
	private WorkerInfoService workerInfoService;
	
	@Resource(name="managerInfoServiceImpl")
	private ManagerInfoService managerInfoService;
	
	@Resource(name="menuInfoServiceImpl")
	private MenuInfoService menuInfoService;
	
	@Resource(name="roleInfoServiceImpl")
	private RoleInfoService roleInfoService;
	
	@Resource(name="authorityInfoServiceImpl")
	private AuthorityInfoService authorityInfoService;
	
	@Resource(name="businessCropProjectInfoServiceImpl")
	private BusinessCropProjectInfoService businessCropProjectInfoService;
	
	@RequestMapping("login.do")
	public String login(UserInfo user,HttpSession session,Model model)
	{
		String num = user.getUserNum();
		String pwd = user.getUserPwd();
		String type = user.getUserType();
		System.out.println(user.toString());
		if(type.equals("0"))
		{
			ManagerInfo manager = new ManagerInfo();
			manager.setManagerNum(num);
			manager.setManagerPwd(pwd);
			manager = managerInfoService.getManagerInfo(manager);
			if(manager!=null)
			{
				session.setAttribute("managerInfo", manager);
				return "business/manager.jsp";
			}
			else
			{
				return "business/login.html";
			}	
		}
		//普通用户分权限
		if(type.equals("1"))
		{
			WorkerInfo worker = new WorkerInfo();
			worker.setWorkerNum(num);
			worker.setWorkerPwd(pwd);
			worker = workerInfoService.getWorkerInfo(worker);
			if(worker==null)
			{
				System.out.println("worker is null");
			}
			else
			{
				System.out.println("worker is not null");
				
				session.setAttribute("workerInfo", worker);
				
				int roleId = worker.getRoleId();
				RoleInfo role = roleInfoService.getRoleAuthority(roleId);
				System.out.println(role.toString());
				String rolelist = role.getRoleAuthority();
				String[] roles=rolelist.split("：");
				System.out.println("共有"+roles.length+"个权限");
				List<Integer> authorityIds = new ArrayList<Integer>();
				for(int i=0;i<roles.length;i++)
				{
					authorityIds.add(Integer.parseInt(roles[i]));
				}
				/*
				 * 得到菜单数量
				 */
				List<MenuInfo> list = menuInfoService.getMenuByAuthorityId(authorityIds);
				System.out.println("menu num "+list.size());
				for(int i=0;i<list.size();i++)
				{
					System.out.println(list.get(i).toString());
				}
				session.setAttribute("menus", list);		
				return "business/gerneral.jsp";
			}
		}
		return "business/login.html";
	}
	
	
	@RequestMapping("logout.do")
	public @ResponseBody String logout(HttpSession session,String id)
	{
		System.out.println("LOGOUT");
		ManagerInfo manager = (ManagerInfo) session.getAttribute("managerInfo");
		
		if(manager!=null)
		{
			session.removeAttribute("managerInfo");
			System.out.println("num:"+manager.getManagerNum());
			System.out.println("num:"+manager.getManagerNum());
			return "true";
		}
		WorkerInfo worker = (WorkerInfo) session.getAttribute("workerInfo");
		
		if(worker!=null)
		{
			session.removeAttribute("workerInfo");
			System.out.println("num:"+worker.getWorkerNum());	
			return "true";
		}
		return "false";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * 数据填充
	 */
	@RequestMapping("getAuthority.do")
	public @ResponseBody ModelMap getAuthority(WorkerInfo user)
	{
		/*
		int workerId = user.getWorkerId();
		System.out.println(user.getWorkerNum()+"roleId"+user.getRoleId());
		
		System.out.println(user.getWorkerNum()+"roleId"+user.getRoleId());
		RoleInfo role = roleInfoService.getRoleAuthority(user.getRoleId());
		System.out.println(role.toString());
		String rolelist = role.getRoleAuthority();
		String[] roles=rolelist.split("：");
		System.out.println("共有"+roles.length+"个权限");
		
		int[] authorityIds = null;
		for(int i=0;i<roles.length;i++)
		{
			authorityIds[i]=Integer.parseInt(roles[i]);
		}
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0;i<roles.length;i++)
		{
			AuthorityInfo authorityInfo=authorityInfoService.getAuthority(Integer.parseInt(roles[i]));
			System.out.println("页面:"+authorityInfo.toString());
			list.add(authorityInfo.toString());
		}

		ModelMap model = new ModelMap();
		
		
		//得到用户的workerId查询business_crop_projectinfo表，得到参与的项目溯源码
		
		BusinessCropProjectInfo businessCropProjectInfo = new BusinessCropProjectInfo();
		businessCropProjectInfo.setWorkerId(workerId);
		System.out.println("workerId	"+workerId);
		businessCropProjectInfo=businessCropProjectInfoService.getBusinessCropProjectInfo(businessCropProjectInfo);
		System.out.println("btcode:	"+businessCropProjectInfo.getWorkerId()+" "+businessCropProjectInfo.getProject_btCode());
		
		
		
		model.addAttribute("btcode", businessCropProjectInfo.getProject_btCode());
	
		//得到此用户参与的生产计划planid查询product_planinfo，得到此生产项目种植员的权限
		
		model.addAttribute("role", list);
		*/
		ModelMap model = new ModelMap();
		return model;
	}
}

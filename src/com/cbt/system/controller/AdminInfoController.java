package com.cbt.system.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cbt.system.po.AuthorityInfo;
import com.cbt.system.po.RoleInfo;
import com.cbt.system.po.AdminInfo;
import com.cbt.system.service.AuthorityInfoService;
import com.cbt.system.service.RoleInfoService;
import com.cbt.system.service.AdminInfoService;

/**
 * 用户信息管理的控制器
 * @hzhqian
 * * 2015年2月10日
 *
 */
@Controller
@RequestMapping("/system/")
public class AdminInfoController {
	
	@Resource(name="adminInfoServiceImpl")
	private AdminInfoService adminInfoService;
	
	
	@Resource(name="roleInfoServiceImpl")
	private RoleInfoService roleInfoService;
	
	@Resource(name="authorityInfoServiceImpl")
	private AuthorityInfoService authorityInfoService;

	/**
	 * 用户注册
	 * 
	 * @param user
	 * @return
	 */
	/*
	@RequestMapping("reg.do")
	public @ResponseBody String reg(UserInfo user) {

		Boolean mark = userInfoService.addUserInfo(user);
		if(mark) return "注册成功";
		else	return "此用户名已被占用";
	}
	*/
	
	/**
	 * 用户登录
	 * @param user
	 * @param session
	 * @return
	 */
	@RequestMapping("login.do")
	public String login(AdminInfo admin,HttpSession session,Model model)
	{
		System.out.println(admin.toString());
		//获取到登录信息
		if(admin.getAdminNum()==""||admin.getAdminPwd()=="")
		{
			return "system/login.html";
		}
		else
		{
			//到数据库中获取属性
			AdminInfo adminInfo = adminInfoService.getAdminInfo(admin);
			if(adminInfo==null)
			{
				System.out.println("data.html");
				return "system/data.html";
			}
			else
			{
				session.setAttribute("admin", admin);
				return "system/data.html";
			}
		}
		/*
		AdminInfo userInfo = userInfoService.getUserInfo(user);
		System.out.println("----");
		System.out.println(userInfo.toString());
		System.out.println("----");
		int roleId = userInfo.getRoleId();
		
		RoleInfo info = roleInfoService.getRoleAuthority(roleId);
		String str = info.getRoleAuthority();
		System.out.println("权限:"+str);
		String[] lists = str.split(":");
		System.out.println("权限长度:"+lists.length);
		String[] urls = new String[5];
		for(int i=0;i<lists.length;i++)
		{
			AuthorityInfo ainfo=authorityInfoService.getAuthority(Integer.parseInt(lists[i]));
			urls[i]=ainfo.getAuthorityUrl();
		}
		
		
		//传输信息封装成对象，放置在session里,session会话
		if(userInfo!=null){
			session.setAttribute("userInfo", userInfo);
			return "";
		}else{
			model.addAttribute("error", "账号或密码错误，请重新输入");
		}
	*/
	}
	
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	/*
	@RequestMapping("update.do")
	public String update(UserInfo user,HttpSession session,Model model){
		
		boolean mark = userInfoService.updateUserInfo(user);
		if(mark){
			session.setAttribute("userInfo", user);
			model.addAttribute("info", "用户信息修改成功");
		}else{
			model.addAttribute("info", "用户信息修改失败");
		}
		
		
		return "view/system/userinfo/user_update";
	}
	*/
/*
	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	public void setMenuInfoService(MenuInfoService menuInfoService) {
		this.menuInfoService = menuInfoService;
	}
	*/

	
	@RequestMapping("test.do")
	public String test(HttpSession session,Model model){
		
		System.out.println("hello world");
		return "view/system/userinfo/user_update";
	}
	
	
	/**
	 * 返回用户列表
	 * @param page
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	/*
	@RequestMapping("getGerenUserList.do")
	public @ResponseBody ModelMap getGerenUserList(String page,String rows,String status
			) throws Exception{
		if(status==null) status="";
		List<UserInfoVo> userInfoVo = userInfoService.getUserInfoVo(page,rows,status);
		ModelMap model = new ModelMap();
		model.addAttribute("total",userInfoService.getGerenUserCount(status));
		model.addAttribute("rows",userInfoVo);
		
		return model;
	}
	*/
	/**
	 * 审核通过
	 * @param data
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	/*
	@RequestMapping("checkUser.do")
	public @ResponseBody String checkUser(String data) throws JsonParseException, JsonMappingException, IOException{
		
		try{
			ObjectMapper mapper = new ObjectMapper();
			JavaType type = mapper.getTypeFactory().constructParametricType(ArrayList.class, UserInfoVo.class);
			@SuppressWarnings("unchecked")
			List<UserInfoVo> userInfoVoList = (ArrayList<UserInfoVo>)mapper.readValue(data, type);
			userInfoService.updateUserStatus(userInfoVoList, "通过");
			return "success";
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
	}
	*/
	/**
	 * 封杀用户
	 * @param data
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	/*
	@RequestMapping("forceOutUser.do")
	public @ResponseBody String forceOutUser(String data) throws JsonParseException, JsonMappingException, IOException{
		
		try{
			ObjectMapper mapper = new ObjectMapper();
			JavaType type = mapper.getTypeFactory().constructParametricType(ArrayList.class, UserInfoVo.class);
			@SuppressWarnings("unchecked")
			List<UserInfoVo> userInfoVoList = (ArrayList<UserInfoVo>)mapper.readValue(data, type);
			userInfoService.updateUserStatus(userInfoVoList, "封号");
			return "success";
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
	}
	
	@RequestMapping("showDetails.do")
	public @ResponseBody Object showDetails(String userName,String userType) throws UnsupportedEncodingException{
		
		String userId = URLDecoder.decode(userName,"UTF-8");
		String YHLX = URLDecoder.decode(userType,"UTF-8");
		ModelMap model = new ModelMap();
		
		if(YHLX.equals("个人用户")){
			GerenInfo gerenInfo = gerenInfoService.getGerenInfoById(userId);
			model.addAttribute("rows",gerenInfo.getProperty());
			return model;
		}else if(YHLX.equals("创新团队")){
			CxtdInfo cxtdInfo = cxtdInfoService.getCxtdInfoByUserId(userId);
			model.addAttribute("rows",cxtdInfo.getProperty());
			return model;
		}else if(YHLX.equals("企业用户")){
			QyInfo qyInfo = qyInfoService.getQyInfoByUserId(userId);
			model.addAttribute("rows",qyInfo.getProperty());
			return model;
		}else if(YHLX.equals("高校用户")){
			GxInfo gxInfo = gxInfoService.getGxInfoByUserId(userId);
			model.addAttribute("rows",gxInfo.getProperty());
			return model;
		}else{
			return "fail";
		}
		
	}
	*/
	
}

package com.cbt.business.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cbt.business.po.BusinessInfo;
import com.cbt.business.po.CropBackPicInfo;
import com.cbt.business.service.BusinessInfoService;
import com.cbt.utils.DirCopyTool;
import com.cbt.utils.PathConfig;

@Controller
@RequestMapping("/business/")
public class BusinessInfoController 
{
	
	@Resource(name="pathConfig")
	private PathConfig pathConfig;
	//分页获取种植员自己的种植纪录
	@Resource(name="businessInfoServiceImpl")
	private BusinessInfoService businessInfoService;
	@RequestMapping("getPageBusinesss.do")
	public @ResponseBody ModelMap getPageBusinesss(HttpServletRequest req,HttpSession session)
	{	
		int nowpage = Integer.parseInt(req.getParameter("pageNumber"));
		int rows = Integer.parseInt(req.getParameter("pageSize"));	
		ModelMap model = new ModelMap();
		
		List<BusinessInfo> lists = new ArrayList<BusinessInfo>();
		
		
		lists = businessInfoService.getPageBusinesss(nowpage, rows);
		System.out.println(lists.get(0).getBusinessMobile());
		System.out.println(lists.get(0).getBusinessMobile());
		model.put("rows", lists);	
		int total = businessInfoService.getBusinesssCount();	
		model.put("total", total);	
		return model;
	}
	
	@RequestMapping("addBusiness.do")
	public @ResponseBody String addBusiness(BusinessInfo info)
	{
		Boolean mark = true;
		mark = businessInfoService.addBusiness(info);
		return mark.toString();
	}
	
	
	
	
	//修改一条数据参数roleinfo info
	@RequestMapping("updateBusiness.do")
	public @ResponseBody String updateRole(BusinessInfo info)
	{
	    Boolean mark = true; 
	    //调用service更新数据库
	   
	    mark = businessInfoService.updateBusiness(info);
	    
	    return mark.toString();
	}
	
	
	
	//删除数据
	@RequestMapping("delBusiness.do")
	public @ResponseBody String delRole(String data) throws JsonParseException, JsonMappingException, IOException
		{
			ObjectMapper mapper=new ObjectMapper();
			JavaType javatype=mapper.getTypeFactory().constructParametricType(ArrayList.class,BusinessInfo.class);	
		    List<BusinessInfo> list=mapper.readValue(data, javatype);
		    //循环删除list数据
		    System.out.println("shanchu");
		    
			return businessInfoService.delBusiness(list).toString();
		}

	
	
	//企业修改信息时获取单个信息
	@RequestMapping("getBusinessInfo.do")
	public @ResponseBody ModelMap getBusinessInfo(String businessId)
	{
		ModelMap model = new ModelMap();
		
		BusinessInfo info = new BusinessInfo();
		info.setBusinessId(businessId);
		info = businessInfoService.getBusinessInfo(info);
		if(info!=null)
		{
			model.addAttribute("businessInfo",info);
		}
		return model;		
	}
	
	
	@RequestMapping("updateBusinessInfo.do")
	public @ResponseBody String updateBusinessInfo(@RequestParam(value="logo") MultipartFile logo,BusinessInfo info
			,HttpServletRequest req)
	{	
		Boolean mark=false;
		//处理logo上传
		String parentPath= req.getSession().getServletContext().getRealPath(pathConfig.getBusinessLogoPath());
		System.out.println(parentPath);
		//删除服务器存储的图片，使用服务器绝对地址
		/*File f = new File(parentPath+"/20170711/1530820170711090204.jpg");*/

		//服务器绝对地址
		//将图片地址存到数据库中CropBackPicInfo
		//http://localhost:8081/CropBacktracking/Uploads/business/111201799/1.jpg
		DirCopyTool dirCopyTool=new DirCopyTool();
		if(logo==null)
		{
			BusinessInfo binfo = businessInfoService.getBusinessInfo(info);
			String logopath = binfo.getBusinessLogo();
			info.setBusinessLogo(logopath);
		}
		if(logo!=null)
		{
			String logoname = dirCopyTool.saveLogoFile(parentPath+"/"+info.getBusinessId()+"/", logo,"logo");
			info.setBusinessLogo(pathConfig.getBusinessLogoPath()+"/"+info.getBusinessId()+"/"+logoname);
			//String imgPath = pathConfig.getLocalPath()+"/"+projectCode+"/"+"1";
		}
		
		mark=businessInfoService.updateBusiness(info);
		return mark.toString();
	}	
}

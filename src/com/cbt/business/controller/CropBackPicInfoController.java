package com.cbt.business.controller;

import java.io.File;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cbt.business.po.CropBackPicInfo;
import com.cbt.utils.DirCopyTool;
import com.cbt.utils.PathConfig;

/*
 * 溯源页面图片上传处理
 */

@Controller
@RequestMapping("/business/")
public class CropBackPicInfoController 
{
	
	@Resource(name="pathConfig")
	private PathConfig pathConfig;
	
	@RequestMapping("picUpload.do")
	public String test(@RequestParam("img1") MultipartFile img1,
			@RequestParam("img2") MultipartFile img2,
			@RequestParam("img3") MultipartFile img3,
			@RequestParam("img4") MultipartFile img4,
			@RequestParam("img5") MultipartFile img5
			,HttpServletRequest req) throws Exception{
		
		//图片存储地址
		String parentPath= req.getSession().getServletContext().getRealPath(pathConfig.getLocalPath());
		//删除服务器存储的图片，使用服务器绝对地址
		File f = new File(parentPath+"/20170711/1530820170711090204.jpg");
		System.out.println(f.delete());
		//服务器绝对地址
		System.out.println(parentPath);
		DirCopyTool dirCopyTool=new DirCopyTool();		
		String savePath = dirCopyTool.saveLogoFile(parentPath, img1);	
		/*
		//相对地址
		System.out.println(savePath);
		
		//string->Date
		System.out.println(info.getDemodate().toString());
		
		
		//Date->String
		String sdate=(new SimpleDateFormat("yyyy-MM-dd")).format(info.getDemodate());  
		
		System.out.println(sdate);
		
		
		info.setLogoaddr(savePath);
		*/
		return "lifeline.html";
	}
	
}

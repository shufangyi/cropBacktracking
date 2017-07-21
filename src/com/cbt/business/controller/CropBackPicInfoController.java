package com.cbt.business.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cbt.business.po.CropBackPicInfo;
import com.cbt.business.service.CropBackPicInfoService;
import com.cbt.utils.DirCopyTool;
import com.cbt.utils.PathConfig;


/*
 * 溯源页面图片上传处理
 */

@Controller
@RequestMapping("/business/")
public class CropBackPicInfoController 
{
	@Resource(name="cropBackPicInfoServiceImpl")
	private CropBackPicInfoService cropBackPicInfoService;
	
	
	@Resource(name="pathConfig")
	private PathConfig pathConfig;
	
	@RequestMapping("picUpload.do")
	public String test(String projectCode,
			@RequestParam(value="img1") MultipartFile img1,
			@RequestParam(value="img2") MultipartFile img2,
			@RequestParam(value="img3") MultipartFile img3,
			@RequestParam(value="img4") MultipartFile img4,
			@RequestParam(value="img5") MultipartFile img5,
			HttpServletRequest req) throws Exception{
		//图片存储地址
		System.out.println("projectCode:"+projectCode);
		String parentPath= req.getSession().getServletContext().getRealPath(pathConfig.getLocalPath());
		System.out.println(parentPath);
		//删除服务器存储的图片，使用服务器绝对地址
		/*File f = new File(parentPath+"/20170711/1530820170711090204.jpg");*/

		//服务器绝对地址
		//将图片地址存到数据库中CropBackPicInfo
		//http://localhost:8081/CropBacktracking/Uploads/business/111201799/1.jpg
		System.out.println(parentPath);
		DirCopyTool dirCopyTool=new DirCopyTool();
		if(img1!=null)
		{
			String savePath1 = dirCopyTool.saveLogoFile(parentPath+"/"+projectCode+"/", img1,"1");
			CropBackPicInfo info = new CropBackPicInfo();
			info.setLoc("1");
			//String imgPath = pathConfig.getLocalPath()+"/"+projectCode+"/"+"1";
			info.setPicUrl(pathConfig.getLocalPath()+"/"+projectCode+"/"+savePath1);
			info.setProjectCode(projectCode);
			//img1不为空，将本项目之前的图片删除
			if(cropBackPicInfoService.deleteByProjectCodeService(info)<=0){
				System.out.println("图片删除失败或项目无历史图片");
			}
			//调用service,插入存储
			cropBackPicInfoService.saveCropBackPicInfo(info);
			
		}
		if(img2!=null)
		{
			String savePath2 = dirCopyTool.saveLogoFile(parentPath+"/"+projectCode+"/", img2,"2");
			CropBackPicInfo info = new CropBackPicInfo();
			info.setLoc("2");
			info.setPicUrl(pathConfig.getLocalPath()+"/"+projectCode+"/"+savePath2);
			info.setProjectCode(projectCode);
			//img2不为空，将本项目之前的图片删除
			if(cropBackPicInfoService.deleteByProjectCodeService(info)<=0){
				System.out.println("图片删除失败或项目无历史图片");
			}
			//调用service
			cropBackPicInfoService.saveCropBackPicInfo(info);
		}
		if(img3!=null)
		{
			String savePath3 = dirCopyTool.saveLogoFile(parentPath+"/"+projectCode+"/", img3,"3");
			CropBackPicInfo info = new CropBackPicInfo();
			info.setLoc("3");
			info.setPicUrl(pathConfig.getLocalPath()+"/"+projectCode+"/"+savePath3);
			info.setProjectCode(projectCode);
			//img3不为空，将本项目之前的图片删除
			if(cropBackPicInfoService.deleteByProjectCodeService(info)<=0){
				System.out.println("图片删除失败或项目无历史图片");
			}
			//调用service
			cropBackPicInfoService.saveCropBackPicInfo(info);
		}
		if(img4!=null)
		{
			String savePath4 = dirCopyTool.saveLogoFile(parentPath+"/"+projectCode+"/", img4,"4");
			CropBackPicInfo info = new CropBackPicInfo();
			info.setLoc("4");
			info.setPicUrl(pathConfig.getLocalPath()+"/"+projectCode+"/"+savePath4);
			info.setProjectCode(projectCode);
			//img4不为空，将本项目之前的图片删除
			if(cropBackPicInfoService.deleteByProjectCodeService(info)<=0){
				System.out.println("图片删除失败或项目无历史图片");
			}
			//调用service
			cropBackPicInfoService.saveCropBackPicInfo(info);
		}
		if(img5!=null)
		{
			String savePath5 = dirCopyTool.saveLogoFile(parentPath+"/"+projectCode+"/", img5,"5");
			CropBackPicInfo info = new CropBackPicInfo();
			info.setLoc("5");
			info.setPicUrl(pathConfig.getLocalPath()+"/"+projectCode+"/"+savePath5);
			info.setProjectCode(projectCode);
			//img5不为空，将本项目之前的图片删除
			if(cropBackPicInfoService.deleteByProjectCodeService(info)<=0){
				System.out.println("图片删除失败或项目无历史图片");
			}
			//调用service
			cropBackPicInfoService.saveCropBackPicInfo(info);
		}
		/*
		//相对地址
		//string->Date
		System.out.println(info.getDemodate().toString());
		//Date->String
		String sdate=(new SimpleDateFormat("yyyy-MM-dd")).format(info.getDemodate());  	
		System.out.println(sdate);
		info.setLogoaddr(savePath);
		*/
		return "";
	}
	
	
	
	@RequestMapping("getImgs.do")
	public @ResponseBody ModelMap getImgsById(String queryId)
	{
		ModelMap model = new ModelMap();
		String projectCode = queryId.substring(0,9);
		
		CropBackPicInfo info = new CropBackPicInfo();
		List<CropBackPicInfo> list = cropBackPicInfoService.getCropBackPicInfoByProjectCode(projectCode);
		model.addAttribute("imglist",list);
		
		return model;
	}
	
	
	
	
}

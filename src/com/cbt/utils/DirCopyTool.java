package com.cbt.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.StringTokenizer;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * 复制文件夹tools
 * 两个构造方法
 *public DirCopyTool(String sourceDir,String targetDir) throws IOException
 * 参数 DirCopyTool(String sourceDir,String targetDir)
 *  sourceDir源文件名称，targetDir目标文件名称
 *public DirCopyTool(File sourceFile, File targetFile) throws IOException
 *  sourceFile源文件名称，targetFile目标文件名称
 * @author Zhou
 *
 */
public class DirCopyTool 
{
	
	
	public DirCopyTool() {}
	public DirCopyTool(String sourceDir,String targetDir) throws IOException
	 {
		copyDirectiory(sourceDir,targetDir);
	 }
	public DirCopyTool(File sourceFile, File targetFile) throws IOException
	{
		copyFile(sourceFile,targetFile);
	}
	 //复制文件
	 public  void copyDirectiory(String sourceDir, String targetDir)
	    throws IOException {
	   //新建目标目录
	  (new File(targetDir)).mkdirs();
	   // 获取源文件夹当前下的文件或目�?
	  File[] file = (new File(sourceDir)).listFiles();
	   for (int i = 0; i < file.length; i++) {
	    if (file[i].isFile()) {
	     // 源文件
	    File sourceFile = file[i];
	     // 目标文件
	    File targetFile = new File(new File(targetDir)
	       .getAbsolutePath()
	       + File.separator + file[i].getName());
	     copyFile(sourceFile, targetFile);
	    }
	    if (file[i].isDirectory()) {
	     // 准备复制的源文件�?
	    String dir1 = sourceDir + "/" + file[i].getName();
	     // 准备复制的目标文件夹
	    String dir2 = targetDir + "/" + file[i].getName();
	    copyDirectiory(dir1, dir2);
	    }
	   }
	  }
	  // 复制文件
	  public void copyFile(File sourceFile, File targetFile)
	    throws IOException {
	   //新建文件输入流并对它进行缓冲
	  FileInputStream input = new FileInputStream(sourceFile);
	  BufferedInputStream inBuff = new BufferedInputStream(input);

	  //  新建文件输出流并对它进行缓冲
	   FileOutputStream output = new FileOutputStream(targetFile);
	   BufferedOutputStream outBuff = new BufferedOutputStream(output);

	  //缓冲数组
	   byte[] b = new byte[1024 * 5];
	   int len;
	   while ((len = inBuff.read(b)) != -1) {
	    outBuff.write(b, 0, len);
	   }
	   // 刷新此缓冲的输出
	  outBuff.flush();

	  // 关闭
	   inBuff.close();
	   outBuff.close();
	   output.close();
	   input.close();
	  }
	  
	  public void copyImagesByTime(String path,String taget){
			String ymd=new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
			String realPath = path+"/"+ymd+"/";
			String targetDir = taget+"/"+ymd+"/"; 
			File f = new File(realPath);
			if(f.exists())
				try {
					copyDirectiory(realPath, targetDir);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}  
	  
	  public String saveLogoFile(String path, MultipartFile file)
		{
			String ymd=new SimpleDateFormat("/yyyyMMdd/").format(Calendar.getInstance().getTime());
			String newsLogoPath = getRandomFileName()+"."+getFileSuffix(file.getOriginalFilename());
			String parentPath=path+ymd;
			try{
			  FileUtils.copyInputStreamToFile(file.getInputStream(), new File(parentPath,newsLogoPath)); 
			}catch(Exception e){
				e.getMessage();
			}
			return "Uploads/patent"+ymd+newsLogoPath;
		}
	  
	//根据时间产生随机文件
	    public  String getRandomFileName() {  
	    	  
	        SimpleDateFormat simpleDateFormat;  
	  
	        simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");  
	  
	        Date date = new Date();  
	  
	        String str = simpleDateFormat.format(date);  
	  
	        Random random = new Random();  
	  
	        int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数  
	  
	        return rannum + str;// 当前时间  
	    } 
	    //获取文件后缀
	   public String getFileSuffix(String  fileName)
	   {
		   StringTokenizer  stf=new StringTokenizer(fileName,".");
		   String filesuffix="";
		   while(stf.hasMoreTokens()){
				filesuffix=stf.nextToken();
			}
		 return filesuffix;
		   
	   }
	    
}

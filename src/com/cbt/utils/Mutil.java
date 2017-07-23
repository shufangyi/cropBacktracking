package com.cbt.utils;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class Mutil {
/**
 * 
 * @param fromemail
 * @param frompassword
 * @param toemail
 * @param subject
 * @param content
 * @throws EmailException
 */
	//public void send(String fromemail,String fromname,String frompassword,String fromhostname, String toemail,String toname,String subject,String content)
		//	throws EmailException{
	public void send(String fromemail,String frompassword, String toemail,String subject,String content)
			throws EmailException{
		/*
        System.out.println(fromemail);
        System.out.println(frompassword);
        System.out.println(toemail);
        System.out.println(subject);
        System.out.println(content);
        */
		//String fromemail = "zww12139@sina.com";
		//String fromname = "zww12139";
		//String password = "951029951029";"smtp.sina.com"
		  int n =fromemail.indexOf('@');
	      int m=fromemail.length() ;
	       
	    String fromhostname ="smtp."+fromemail.substring(n+1,m);
	    String fromname=fromemail.substring(0,n);
	    int n1=toemail.indexOf('@');
	    String toname=toemail.substring(0, n1);
		HtmlEmail multipartemail = new HtmlEmail();
		multipartemail.setHostName(fromhostname);
		multipartemail.setSmtpPort(25);
		multipartemail.addTo(toemail, toname);
		multipartemail.setFrom(fromemail, fromname);
		multipartemail.setAuthentication(fromemail, frompassword);
		multipartemail.setSubject(subject); 
		multipartemail.setCharset("gb2312");
		multipartemail.setHtmlMsg(content); 
		multipartemail.send(); 
		}
	}



package com.cbt.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;  

public class DateConverter implements Converter<String,Date>{
	
	
	private static final SimpleDateFormat[] ACCEPT_DATE_FORMATS = {  
			new SimpleDateFormat("yyyy-MM-dd"),  
	        new SimpleDateFormat("yyyy/MM/dd")  
	};  
	
	@Override
	public Date convert(String source) {
		// TODO Auto-generated method stub
		for(SimpleDateFormat format : ACCEPT_DATE_FORMATS){  
	    try{  
	    	Date tmp = format.parse(source);  
	    	return tmp;  
	     	}
	    catch (Exception e) {      
	    	//e.printStackTrace();  
	    	continue;  
	    	} 
		}  
		return null;
		  /*
		  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		  try {  
			  return simpleDateFormat.parse(source);  
		  }
		  catch (ParseException e) {  
			  e.printStackTrace();  
		  }
		  return null;
		  */
	}
}

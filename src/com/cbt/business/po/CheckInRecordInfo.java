package com.cbt.business.po;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.cbt.business.controller.JsonDateSerializer;

public class CheckInRecordInfo {
	 private Integer id;

	    private String picksegBtcode;

	    private Date checkintime;

	    private String checkinsegBtcode;

	    private String stocklocation;

	    private Integer fertilizernum;

	    private String comment;

	    private String checker;

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }
	    public String getPicksegBtcode() {
	        return picksegBtcode;
	    }

	    public void setPicksegBtcode(String picksegBtcode) {
	        this.picksegBtcode = picksegBtcode == null ? null : picksegBtcode.trim();
	    }

	    
	    @JsonSerialize(using=JsonDateSerializer.class)
	    public Date getCheckintime() {
	        return checkintime;
	    }

	    public void setCheckintime(Date checkintime) {
	        this.checkintime = checkintime;
	    }

	    public String getCheckinsegBtcode() {
	        return checkinsegBtcode;
	    }

	    public void setCheckinsegBtcode(String checkinsegBtcode) {
	        this.checkinsegBtcode = checkinsegBtcode == null ? null : checkinsegBtcode.trim();
	    }

	    public String getStocklocation() {
	        return stocklocation;
	    }

	    public void setStocklocation(String stocklocation) {
	        this.stocklocation = stocklocation == null ? null : stocklocation.trim();
	    }

	    public Integer getFertilizernum() {
	        return fertilizernum;
	    }

	    public void setFertilizernum(Integer fertilizernum) {
	        this.fertilizernum = fertilizernum;
	    }

	    public String getComment() {
	        return comment;
	    }

	    public void setComment(String comment) {
	        this.comment = comment == null ? null : comment.trim();
	    }

	    public String getChecker() {
	        return checker;
	    }

	    public void setChecker(String checker) {
	        this.checker = checker == null ? null : checker.trim();
	    }
}

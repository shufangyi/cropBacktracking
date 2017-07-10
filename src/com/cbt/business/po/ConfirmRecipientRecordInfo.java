package com.cbt.business.po;

import java.util.Date;

public class ConfirmRecipientRecordInfo {
	 private Integer id;

	    private Date recipienttime;

	    private String ordernum;

	    private String logisticsnum;

	    private String comment;

	    private String distributor;

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public Date getRecipienttime() {
	        return recipienttime;
	    }

	    public void setRecipienttime(Date recipienttime) {
	        this.recipienttime = recipienttime;
	    }

	    public String getOrdernum() {
	        return ordernum;
	    }

	    public void setOrdernum(String ordernum) {
	        this.ordernum = ordernum == null ? null : ordernum.trim();
	    }

	    public String getLogisticsnum() {
	        return logisticsnum;
	    }

	    public void setLogisticsnum(String logisticsnum) {
	        this.logisticsnum = logisticsnum == null ? null : logisticsnum.trim();
	    }

	    public String getComment() {
	        return comment;
	    }

	    public void setComment(String comment) {
	        this.comment = comment == null ? null : comment.trim();
	    }

	    public String getDistributor() {
	        return distributor;
	    }

	    public void setDistributor(String distributor) {
	        this.distributor = distributor == null ? null : distributor.trim();
	    }
}

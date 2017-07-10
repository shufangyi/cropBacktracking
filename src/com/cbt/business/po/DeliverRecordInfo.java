package com.cbt.business.po;

import java.util.Date;

public class DeliverRecordInfo {
	    private Integer id;

	    private Date delivertime;

	    private String deliveraddress;

	    private String logisticscompany;

	    private String ordernum;

	    private String logisticsnum;

	    private String distributor;

	    private String comment;

	    private String logistics;

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public Date getDelivertime() {
	        return delivertime;
	    }

	    public void setDelivertime(Date delivertime) {
	        this.delivertime = delivertime;
	    }

	    public String getDeliveraddress() {
	        return deliveraddress;
	    }

	    public void setDeliveraddress(String deliveraddress) {
	        this.deliveraddress = deliveraddress == null ? null : deliveraddress.trim();
	    }

	    public String getLogisticscompany() {
	        return logisticscompany;
	    }

	    public void setLogisticscompany(String logisticscompany) {
	        this.logisticscompany = logisticscompany == null ? null : logisticscompany.trim();
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

	    public String getDistributor() {
	        return distributor;
	    }

	    public void setDistributor(String distributor) {
	        this.distributor = distributor == null ? null : distributor.trim();
	    }

	    public String getComment() {
	        return comment;
	    }

	    public void setComment(String comment) {
	        this.comment = comment == null ? null : comment.trim();
	    }

	    public String getLogistics() {
	        return logistics;
	    }

	    public void setLogistics(String logistics) {
	        this.logistics = logistics == null ? null : logistics.trim();
	    }
}

package com.cbt.business.po;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.cbt.business.controller.JsonDateSerializer;

public class CopackRecordInfo {
	private Integer id;

    private String checkinsegBtcode;

    private Date copacktime;

    private String productQrcodepicture;

    private String ordernum;

    private String productBtcode;

    private String comment;

    private String copacker;

    private String copacklocation;

    private Date producedate;

    private String producelocation;

    private String specifications;

    private String netcontent;

    private String storagecondition;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCheckinsegBtcode() {
        return checkinsegBtcode;
    }

    public void setCheckinsegBtcode(String checkinsegBtcode) {
        this.checkinsegBtcode = checkinsegBtcode == null ? null : checkinsegBtcode.trim();
    }

    @JsonSerialize(using=JsonDateSerializer.class)
    public Date getCopacktime() {
        return copacktime;
    }

    public void setCopacktime(Date copacktime) {
        this.copacktime = copacktime;
    }

    public String getProductQrcodepicture() {
        return productQrcodepicture;
    }

    public void setProductQrcodepicture(String productQrcodepicture) {
        this.productQrcodepicture = productQrcodepicture == null ? null : productQrcodepicture.trim();
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum == null ? null : ordernum.trim();
    }

    public String getProductBtcode() {
        return productBtcode;
    }

    public void setProductBtcode(String productBtcode) {
        this.productBtcode = productBtcode == null ? null : productBtcode.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public String getCopacker() {
        return copacker;
    }

    public void setCopacker(String copacker) {
        this.copacker = copacker == null ? null : copacker.trim();
    }

    public String getCopacklocation() {
        return copacklocation;
    }

    public void setCopacklocation(String copacklocation) {
        this.copacklocation = copacklocation == null ? null : copacklocation.trim();
    }

    public Date getProducedate() {
        return producedate;
    }

    public void setProducedate(Date producedate) {
        this.producedate = producedate;
    }

    public String getProducelocation() {
        return producelocation;
    }

    public void setProducelocation(String producelocation) {
        this.producelocation = producelocation == null ? null : producelocation.trim();
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications == null ? null : specifications.trim();
    }

    public String getNetcontent() {
        return netcontent;
    }

    public void setNetcontent(String netcontent) {
        this.netcontent = netcontent == null ? null : netcontent.trim();
    }

    public String getStoragecondition() {
        return storagecondition;
    }

    public void setStoragecondition(String storagecondition) {
        this.storagecondition = storagecondition == null ? null : storagecondition.trim();
    }
}

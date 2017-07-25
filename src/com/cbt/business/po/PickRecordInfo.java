package com.cbt.business.po;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.cbt.business.controller.JsonDateSerializer;

public class PickRecordInfo {
    private Integer id;

    private String sowsegBtcode;

    private Date picktime;

    private Integer picktype;

    private Integer picknum;

    private String picksegBtcode;

    private String comment;

    private String grower;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSowsegBtcode() {
        return sowsegBtcode;
    }

    public void setSowsegBtcode(String sowsegBtcode) {
        this.sowsegBtcode = sowsegBtcode == null ? null : sowsegBtcode.trim();
    }

    @JsonSerialize(using=JsonDateSerializer.class)
    public Date getPicktime() {
        return picktime;
    }

    public void setPicktime(Date picktime) {
        this.picktime = picktime;
    }

    public Integer getPicktype() {
        return picktype;
    }

    public void setPicktype(Integer picktype) {
        this.picktype = picktype;
    }

    public Integer getPicknum() {
        return picknum;
    }

    public void setPicknum(Integer picknum) {
        this.picknum = picknum;
    }

    public String getPicksegBtcode() {
        return picksegBtcode;
    }

    public void setPicksegBtcode(String picksegBtcode) {
        this.picksegBtcode = picksegBtcode == null ? null : picksegBtcode.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public String getGrower() {
        return grower;
    }

    public void setGrower(String grower) {
        this.grower = grower == null ? null : grower.trim();
    }
}

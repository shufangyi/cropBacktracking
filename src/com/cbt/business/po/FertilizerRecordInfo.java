package com.cbt.business.po;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.cbt.business.controller.JsonDateSerializer;

public class FertilizerRecordInfo {
	private Integer id;

    private String sowsegBtcode;

    private String fertilizername;

    private Date fertilizertime;

    private Integer fertilizernum;

    private Integer fertilizerfrequency;

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

    public String getFertilizername() {
        return fertilizername;
    }

    public void setFertilizername(String fertilizername) {
        this.fertilizername = fertilizername == null ? null : fertilizername.trim();
    }
    
    @JsonSerialize(using=JsonDateSerializer.class)
    public Date getFertilizertime() {
        return fertilizertime;
    }

    public void setFertilizertime(Date fertilizertime) {
        this.fertilizertime = fertilizertime;
    }

    public Integer getFertilizernum() {
        return fertilizernum;
    }

    public void setFertilizernum(Integer fertilizernum) {
        this.fertilizernum = fertilizernum;
    }

    public Integer getFertilizerfrequency() {
        return fertilizerfrequency;
    }

    public void setFertilizerfrequency(Integer fertilizerfrequency) {
        this.fertilizerfrequency = fertilizerfrequency;
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

package com.cbt.business.po;

import java.util.Date;

public class SowRecordInfo
{
    private Integer id;

    private String projectBtcode;

    private Date sowtime;

    private String sowsegBtcode;

    private String productname;

    private String seedsource;

    private Integer sownum;

    private String comment;

    private String grower;

    private String sowlocation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectBtcode() {
        return projectBtcode;
    }

    public void setProjectBtcode(String projectBtcode) {
        this.projectBtcode = projectBtcode == null ? null : projectBtcode.trim();
    }

    public Date getSowtime() {
        return sowtime;
    }

    public void setSowtime(Date sowtime) {
        this.sowtime = sowtime;
    }

    public String getSowsegBtcode() {
        return sowsegBtcode;
    }

    public void setSowsegBtcode(String sowsegBtcode) {
        this.sowsegBtcode = sowsegBtcode == null ? null : sowsegBtcode.trim();
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname == null ? null : productname.trim();
    }

    public String getSeedsource() {
        return seedsource;
    }

    public void setSeedsource(String seedsource) {
        this.seedsource = seedsource == null ? null : seedsource.trim();
    }

    public Integer getSownum() {
        return sownum;
    }

    public void setSownum(Integer sownum) {
        this.sownum = sownum;
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

    public String getSowlocation() {
        return sowlocation;
    }

    public void setSowlocation(String sowlocation) {
        this.sowlocation = sowlocation == null ? null : sowlocation.trim();
    }
     
    public String toString()
    {
    	return "code: "+projectBtcode+"	time: "+sowtime.toString()+" seedsource: "+seedsource+" grower: "+grower;
    }
}

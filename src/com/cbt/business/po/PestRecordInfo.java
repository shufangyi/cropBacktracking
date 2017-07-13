package com.cbt.business.po;

import java.sql.Date;

public class PestRecordInfo {
    private Integer id;

    private String sowsegBtcode;

    private String pesttype;

    private String medicationname;

    private String medicationratio;

    private Integer medicationdosage;

    private String result;

    private String comment;

    private String grower;
    
    private Date sprayTime;
    
    

    public Date getSprayTime() {
		return sprayTime;
	}

	public void setSprayTime(Date sprayTime) {
		this.sprayTime = sprayTime;
	}

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

    public String getPesttype() {
        return pesttype;
    }

    public void setPesttype(String pesttype) {
        this.pesttype = pesttype == null ? null : pesttype.trim();
    }

    public String getMedicationname() {
        return medicationname;
    }

    public void setMedicationname(String medicationname) {
        this.medicationname = medicationname == null ? null : medicationname.trim();
    }

    public String getMedicationratio() {
        return medicationratio;
    }

    public void setMedicationratio(String medicationratio) {
        this.medicationratio = medicationratio == null ? null : medicationratio.trim();
    }

    public Integer getMedicationdosage() {
        return medicationdosage;
    }

    public void setMedicationdosage(Integer medicationdosage) {
        this.medicationdosage = medicationdosage;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
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

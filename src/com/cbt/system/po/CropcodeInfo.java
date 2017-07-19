package com.cbt.system.po;

public class CropcodeInfo {
    private Integer id;

    private Integer cropCode;

    private String cropName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCropcode() {
        return cropCode;
    }

    public void setCropcode(Integer cropCode) {
        this.cropCode = cropCode;
    }

    public String getCropname() {
        return cropName;
    }

    public void setCropname(String cropname) {
        this.cropName = cropName == null ? null : cropName.trim();
    }
}
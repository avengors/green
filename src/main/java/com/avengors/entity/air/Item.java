package com.avengors.entity.air;

import java.util.List;
import java.util.Map;

public class Item {
    private List<String> imageUrls;
    private String informCode;
    private String actionKnack;
    private String informCause;
    private String informOverall;
    private String informData;
    private String dataTime;
    private Map<String, String> informGrade;

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public String getInformCode() {
        return informCode;
    }

    public void setInformCode(String informCode) {
        this.informCode = informCode;
    }

    public String getActionKnack() {
        return actionKnack;
    }

    public void setActionKnack(String actionKnack) {
        this.actionKnack = actionKnack;
    }

    public String getInformCause() {
        return informCause;
    }

    public void setInformCause(String informCause) {
        this.informCause = informCause;
    }

    public String getInformOverall() {
        return informOverall;
    }

    public void setInformOverall(String informOverall) {
        this.informOverall = informOverall;
    }

    public String getInformData() {
        return informData;
    }

    public void setInformData(String informData) {
        this.informData = informData;
    }

    public String getDataTime() {
        return dataTime;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    public Map<String, String> getInformGrade() {
        return informGrade;
    }

    public void setInformGrade(Map<String, String> informGrade) {
        this.informGrade = informGrade;
    }
}

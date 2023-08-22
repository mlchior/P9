package com.medApp.analyzerservice.dto;

import com.medApp.analyzerservice.constante.RiskLevel;

public class PatientAnalyseDTO {

    private String lastName;
    private long age;
    private String sex;

    RiskLevel riskLevel;

    public PatientAnalyseDTO() {
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public RiskLevel getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(RiskLevel riskLevel) {
        this.riskLevel = riskLevel;
    }
}

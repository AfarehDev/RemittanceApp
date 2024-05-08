package com.example.remittanceapp.domain.model;

public class SendRemittance {
    private boolean status;
    private int errorNumber;
    private String description;
    private long referance;
    private String referance2;
    private String referance3;

    public SendRemittance(boolean status, int errorNumber, String description, long referance, String referance2, String referance3) {
        this.status = status;
        this.errorNumber = errorNumber;
        this.description = description;
        this.referance = referance;
        this.referance2 = referance2;
        this.referance3 = referance3;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getErrorNumber() {
        return errorNumber;
    }

    public void setErrorNumber(int errorNumber) {
        this.errorNumber = errorNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getReferance() {
        return referance;
    }

    public void setReferance(long referance) {
        this.referance = referance;
    }

    public String getReferance2() {
        return referance2;
    }

    public void setReferance2(String referance2) {
        this.referance2 = referance2;
    }

    public String getReferance3() {
        return referance3;
    }

    public void setReferance3(String referance3) {
        this.referance3 = referance3;
    }
}

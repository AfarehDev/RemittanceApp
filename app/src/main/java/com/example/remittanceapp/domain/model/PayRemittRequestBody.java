package com.example.remittanceapp.domain.model;

public class PayRemittRequestBody {

    private int remId;
    private int paidSeq;
    private int remAmount;
    private int remCurrancy;
    private String remSender;
    private String remReciver;
    private int payToAccount;
    private int feeId;
    private String pcName;
    private String agentComment;

    public PayRemittRequestBody(int remId, int remAmount, String remSender, String remReciver, int feeId) {
        this.remId = remId;
        this.paidSeq = 0;
        this.remAmount = remAmount;
        this.remCurrancy = 1;
        this.remSender = remSender;
        this.remReciver = remReciver;
        this.payToAccount = 0;
        this.feeId = feeId;
        this.pcName = "";
        this.agentComment = "";
    }

    public int getRemId() {
        return remId;
    }

    public void setRemId(int remId) {
        this.remId = remId;
    }

    public int getPaidSeq() {
        return paidSeq;
    }

    public void setPaidSeq(int paidSeq) {
        this.paidSeq = paidSeq;
    }

    public int getRemAmount() {
        return remAmount;
    }

    public void setRemAmount(int remAmount) {
        this.remAmount = remAmount;
    }

    public int getRemCurrancy() {
        return remCurrancy;
    }

    public void setRemCurrancy(int remCurrancy) {
        this.remCurrancy = remCurrancy;
    }

    public String getRemSender() {
        return remSender;
    }

    public void setRemSender(String remSender) {
        this.remSender = remSender;
    }

    public String getRemReciver() {
        return remReciver;
    }

    public void setRemReciver(String remReciver) {
        this.remReciver = remReciver;
    }

    public int getPayToAccount() {
        return payToAccount;
    }

    public void setPayToAccount(int payToAccount) {
        this.payToAccount = payToAccount;
    }

    public int getFeeId() {
        return feeId;
    }

    public void setFeeId(int feeId) {
        this.feeId = feeId;
    }

    public String getPcName() {
        return pcName;
    }

    public void setPcName(String pcName) {
        this.pcName = pcName;
    }

    public String getAgentComment() {
        return agentComment;
    }

    public void setAgentComment(String agentComment) {
        this.agentComment = agentComment;
    }
}

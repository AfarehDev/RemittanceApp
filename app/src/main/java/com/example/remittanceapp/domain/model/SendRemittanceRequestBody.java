package com.example.remittanceapp.domain.model;

public class SendRemittanceRequestBody {
    private int expressId;
    private int sendSeq;
    private int finantialNo;
    private int cityId;
    private int distinationId;
    private int branchReciveId;
    private String senderName;
    private int senderMobile;
    private String reciverName;
    private int reciverMobile;
    private int amount;
    private int agentExtraFee;
    private int feeId;
    private int currancyId;
    private int pourposeId;
    private boolean isSusbended;
    private boolean ignoreRedundentCheck;
    private String pcName;
    private String comment;

    public SendRemittanceRequestBody(
            int expressId,
            String senderName,
            int senderMobile,
            String reciverName,
            int reciverMobile,
            int amount,
            int feeId
    ) {
        this.expressId = expressId;
        this.senderName = senderName;
        this.senderMobile = senderMobile;
        this.reciverName = reciverName;
        this.reciverMobile = reciverMobile;
        this.amount = amount;
        this.feeId = feeId;
        this.sendSeq = 1;
        this.finantialNo = 0;
        this.cityId = 1;
        this.distinationId = 0;
        this.branchReciveId = 0;
        this.agentExtraFee = 0;
        this.currancyId = 1;
        this.pourposeId = 1;
        this.isSusbended = true;
        this.ignoreRedundentCheck = true;
        this.pcName = "pcName";
        this.comment = "comment";
    }

    /*public SendRemittanceRequestBody(
            int expressId,
            int sendSeq,
            int financialNo,
            int cityId,
            int destinationId,
            int branchReceiveId,
            String senderName,
            int senderMobile,
            String receiverName,
            int receiverMobile,
            int amount,
            int agentExtraFee,
            int feeId,
            int currencyId,
            int purposeId,
            boolean isSuspended,
            boolean ignoreRedundantCheck,
            String pcName,
            String comment
    ) {
        this.expressId = expressId;
        this.sendSeq = sendSeq;
        this.financialNo = financialNo;
        this.cityId = cityId;
        this.destinationId = destinationId;
        this.branchReceiveId = branchReceiveId;
        this.senderName = senderName;
        this.senderMobile = senderMobile;
        this.receiverName = receiverName;
        this.receiverMobile = receiverMobile;
        this.amount = amount;
        this.agentExtraFee = agentExtraFee;
        this.feeId = feeId;
        this.currencyId = currencyId;
        this.purposeId = purposeId;
        this.isSuspended = isSuspended;
        this.ignoreRedundantCheck = ignoreRedundantCheck;
        this.pcName = pcName;
        this.comment = comment;
    }*/

    public int getExpressId() {return expressId;}
    public void setExpressId(int expressId) { this.expressId = expressId;}
    public int getSendSeq() {return sendSeq;}
    public void setSendSeq(int sendSeq) {this.sendSeq = sendSeq;}
    public int getFinantialNo() {return finantialNo;}
    public void setFinantialNo(int finantialNo) {this.finantialNo = finantialNo;}
    public int getCityId() {return cityId;}
    public void setCityId(int cityId) {this.cityId = cityId;}
    public int getDistinationId() {return distinationId;}
    public void setDistinationId(int distinationId) {this.distinationId = distinationId;}
    public int getBranchReciveId() {return branchReciveId;}
    public void setBranchReciveId(int branchReciveId) {this.branchReciveId = branchReciveId;}
    public String getSenderName() {return senderName;}
    public void setSenderName(String senderName) {this.senderName = senderName;}
    public int getSenderMobile() {return senderMobile;}
    public void setSenderMobile(int senderMobile) {this.senderMobile = senderMobile;}
    public String getReciverName() {return reciverName;}
    public void setReciverName(String reciverName) {this.reciverName = reciverName;}
    public int getReciverMobile() {return reciverMobile;}
    public void setReciverMobile(int reciverMobile) {this.reciverMobile = reciverMobile;}
    public int getAmount() {return amount;}
    public void setAmount(int amount) {this.amount = amount;}

    public int getAgentExtraFee() {return agentExtraFee;}

    public void setAgentExtraFee(int agentExtraFee) {this.agentExtraFee = agentExtraFee;}

    public int getFeeId() {return feeId;}

    public void setFeeId(int feeId) {this.feeId = feeId;}

    public int getCurrancyId() {return currancyId;}

    public void setCurrancyId(int currancyId) {
        this.currancyId = currancyId;
    }

    public int getPourposeId() {
        return pourposeId;
    }

    public void setPourposeId(int pourposeId) {
        this.pourposeId = pourposeId;
    }

    public boolean isSusbended() {
        return isSusbended;
    }

    public void setSusbended(boolean susbended) {
        isSusbended = susbended;
    }

    public boolean isIgnoreRedundentCheck() {
        return ignoreRedundentCheck;
    }

    public void setIgnoreRedundentCheck(boolean ignoreRedundentCheck) {
        this.ignoreRedundentCheck = ignoreRedundentCheck;
    }

    public String getPcName() {
        return pcName;
    }

    public void setPcName(String pcName) {
        this.pcName = pcName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

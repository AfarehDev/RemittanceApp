package com.example.remittanceapp.domain.model;

public class LoginResponse {
    private int userNo;
    private String userName;
    private String accountName;
    private int usrBranch;
    private int destinationNo;
    private int destinationGroup;
    private int groupPrice;
    private int userGroup;
    private int currentCostCenter;
    private String sessionId;
    private int logId;
    private String token;
    private String refreshToken;
    private boolean status;
    private int errorNumber;
    private String description;
    private int reference;
    private String reference2;
    private String reference3;

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getUsrBranch() {
        return usrBranch;
    }

    public void setUsrBranch(int usrBranch) {
        this.usrBranch = usrBranch;
    }

    public int getDestinationNo() {
        return destinationNo;
    }

    public void setDestinationNo(int destinationNo) {
        this.destinationNo = destinationNo;
    }

    public int getDestinationGroup() {
        return destinationGroup;
    }

    public void setDestinationGroup(int destinationGroup) {
        this.destinationGroup = destinationGroup;
    }

    public int getGroupPrice() {
        return groupPrice;
    }

    public void setGroupPrice(int groupPrice) {
        this.groupPrice = groupPrice;
    }

    public int getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(int userGroup) {
        this.userGroup = userGroup;
    }

    public int getCurrentCostCenter() {
        return currentCostCenter;
    }

    public void setCurrentCostCenter(int currentCostCenter) {
        this.currentCostCenter = currentCostCenter;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
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

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public String getReference2() {
        return reference2;
    }

    public void setReference2(String reference2) {
        this.reference2 = reference2;
    }

    public String getReference3() {
        return reference3;
    }

    public void setReference3(String reference3) {
        this.reference3 = reference3;
    }
}

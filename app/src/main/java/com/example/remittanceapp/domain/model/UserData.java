package com.example.remittanceapp.domain.model;

public class UserData {
    private String userName;
    private String token;
    private String accountName;
    private int usrBranch;
    private int destinationNo;
    private int destinationGroup;
    private int groupPrice;
    private int userGroup;

    public UserData(String userName, String token, String accountName, int usrBranch, int destinationNo, int destinationGroup, int groupPrice, int userGroup) {
        this.userName = userName;
        this.token = token;
        this.accountName = accountName;
        this.usrBranch = usrBranch;
        this.destinationNo = destinationNo;
        this.destinationGroup = destinationGroup;
        this.groupPrice = groupPrice;
        this.userGroup = userGroup;
    }

    public UserData() {
    }
    public UserData(LoginResponse response) {
        this.userName = response.getUserName();
        this.token = response.getToken();
        this.accountName = response.getAccountName();
        this.usrBranch = response.getUsrBranch();
        this.destinationNo = response.getDestinationNo();
        this.destinationGroup = response.getDestinationGroup();
        this.groupPrice = response.getGroupPrice();
        this.userGroup = response.getUserGroup();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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
}

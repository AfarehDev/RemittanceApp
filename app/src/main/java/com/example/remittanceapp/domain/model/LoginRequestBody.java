package com.example.remittanceapp.domain.model;

public class LoginRequestBody {
    private int userType;
    private String userName;
    private String password;
    private String machineCode;
    private int machineCode2;
    private boolean isWebService;
    private int version;
    private String webServiceURL;
    private String ipAddress;
    private String pcName;
    private String osName;
    private boolean withLocalData;
    private int lastDistinationId;

    public LoginRequestBody() {
        this.userType = 65;
        this.userName = "11";
        this.password = "123456";
        this.machineCode = "IBSCompany-Test";
        this.machineCode2 = 984556489;
        this.isWebService = true;
        this.version = 100;
        this.webServiceURL = "https://dev2.cismobile.net/API2/";
        this.ipAddress = "string";
        this.pcName = "string";
        this.osName = "string";
        this.withLocalData = true;
        this.lastDistinationId = 0;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMachineCode() {
        return machineCode;
    }

    public void setMachineCode(String machineCode) {
        this.machineCode = machineCode;
    }

    public int getMachineCode2() {
        return machineCode2;
    }

    public void setMachineCode2(int machineCode2) {
        this.machineCode2 = machineCode2;
    }

    public boolean isWebService() {
        return isWebService;
    }

    public void setWebService(boolean webService) {
        isWebService = webService;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getWebServiceURL() {
        return webServiceURL;
    }

    public void setWebServiceURL(String webServiceURL) {
        this.webServiceURL = webServiceURL;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getPcName() {
        return pcName;
    }

    public void setPcName(String pcName) {
        this.pcName = pcName;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public boolean isWithLocalData() {
        return withLocalData;
    }

    public void setWithLocalData(boolean withLocalData) {
        this.withLocalData = withLocalData;
    }

    public int getLastDistinationId() {
        return lastDistinationId;
    }

    public void setLastDistinationId(int lastDistinationId) {
        this.lastDistinationId = lastDistinationId;
    }
}

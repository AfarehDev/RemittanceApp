package com.example.remittanceapp.domain.model;

public class IncomingFee {
    private SearchData searchData;
    private boolean status;
    private int errorNumber;
    private String description;
    private int reference;
    private String reference2;

    // Constructors
    public IncomingFee() {
    }

    // Getters and Setters
    public SearchData getSearchData() {
        return searchData;
    }

    public void setSearchData(SearchData searchData) {
        this.searchData = searchData;
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

    // Inner Class for searchData
    public static class SearchData {
        private int feeId;
        private double agentFee;
        private double networkFee;
        private double destFee;
        private double maxAmount;
        private double minAmount;
        private int currencyId;
        private boolean pinDestFee;

        // Constructors
        public SearchData() {
        }

        // Getters and Setters
        public int getFeeId() {
            return feeId;
        }

        public void setFeeId(int feeId) {
            this.feeId = feeId;
        }

        public double getAgentFee() {
            return agentFee;
        }

        public void setAgentFee(double agentFee) {
            this.agentFee = agentFee;
        }

        public double getNetworkFee() {
            return networkFee;
        }

        public void setNetworkFee(double networkFee) {
            this.networkFee = networkFee;
        }

        public double getDestFee() {
            return destFee;
        }

        public void setDestFee(double destFee) {
            this.destFee = destFee;
        }

        public double getMaxAmount() {
            return maxAmount;
        }

        public void setMaxAmount(double maxAmount) {
            this.maxAmount = maxAmount;
        }

        public double getMinAmount() {
            return minAmount;
        }

        public void setMinAmount(double minAmount) {
            this.minAmount = minAmount;
        }

        public int getCurrencyId() {
            return currencyId;
        }

        public void setCurrencyId(int currencyId) {
            this.currencyId = currencyId;
        }

        public boolean isPinDestFee() {
            return pinDestFee;
        }

        public void setPinDestFee(boolean pinDestFee) {
            this.pinDestFee = pinDestFee;
        }
    }
}

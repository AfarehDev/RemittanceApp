package com.example.remittanceapp.domain.model;

public class IncomeFeeRequestBody {
    private int sourceId;
    private int destinationId;
    private int destinationGroup;
    private double amount;
    private int currencyId;

    // Constructors
    public IncomeFeeRequestBody() {
        this.sourceId = 0;
        this.destinationId = 0;
        this.destinationGroup = 0;
        this.amount = 0;
        this.currencyId = 0;
    }

    public IncomeFeeRequestBody(int sourceId, int destinationId, int destinationGroup, double amount, int currencyId) {
        this.sourceId = sourceId;
        this.destinationId = destinationId;
        this.destinationGroup = destinationGroup;
        this.amount = amount;
        this.currencyId = currencyId;
    }

    // Getters and Setters
    public int getSourceId() {
        return sourceId;
    }

    public void setSourceId(int sourceId) {
        this.sourceId = sourceId;
    }

    public int getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(int destinationId) {
        this.destinationId = destinationId;
    }

    public int getDestinationGroup() {
        return destinationGroup;
    }

    public void setDestinationGroup(int destinationGroup) {
        this.destinationGroup = destinationGroup;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }
}

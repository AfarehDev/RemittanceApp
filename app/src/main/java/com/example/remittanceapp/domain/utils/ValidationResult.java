package com.example.remittanceapp.domain.utils;

public class ValidationResult {
    private boolean successful;
    private String errorMessage;

    public ValidationResult(boolean successful, String errorMessage) {
        this.successful = successful;
        this.errorMessage = errorMessage;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

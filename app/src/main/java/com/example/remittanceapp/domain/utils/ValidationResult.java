package com.example.remittanceapp.domain.utils;
/**
 * This class represents the result of a validation process, and we use it with all validation functions
 * as a general class that contain the validation state and the error message.
 */
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

package com.example.remittanceapp.domain.usecases;

import com.example.remittanceapp.domain.utils.ValidationResult;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

public class ValidateInputs {

    @Inject
    public ValidateInputs() {}

    public ValidationResult validatePhoneNumber(String phone) {

        if (phone == null ||phone.length() != 9) {
            return new ValidationResult(false, "The phone number needs to consist of 9 characters");
        }

        List<String> validStarts = Arrays.asList("77", "78", "71", "70", "73");
        boolean startsWithValidPrefix = false;
        for (String prefix : validStarts) {
            if (phone.startsWith(prefix)) {
                startsWithValidPrefix = true;
                break;
            }
        }

        if (!startsWithValidPrefix) {
            return new ValidationResult(false, "The phone number needs to match a Yemeni company");
        }

        return new ValidationResult(true, "");
    }


    public ValidationResult validateName(String name) {

        if (name == null || name.isEmpty()) {
            return new ValidationResult(false, "Name cannot be empty");
        }

        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);

            if (!isValidNameCharacter(ch)) {
                return new ValidationResult(false, "The name can only contain English or Arabic letters and spaces");
            }
        }

        String[] parts = name.split(" ");
        if (parts.length != 4) {
            return new ValidationResult(false, "The name must have four parts separated by spaces");
        }

        return new ValidationResult(true, "");
    }


    private boolean isEnglishLetter(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }


    private boolean isArabicLetter(char ch) {
        return ch >= '\u0600' && ch <= '\u06FF';
    }


    private boolean isSpace(char ch) {
        return ch == ' ';
    }


    private boolean isValidNameCharacter(char ch) {
        return isEnglishLetter(ch) || isArabicLetter(ch) || isSpace(ch);
    }


}

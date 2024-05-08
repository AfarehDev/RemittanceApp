package com.example.remittanceapp.domain.usecases;

import com.example.remittanceapp.domain.utils.ValidationResult;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import javax.inject.Inject;

public class ValidateInputs {

    @Inject
    public ValidateInputs() {
    }

    public ValidationResult validatePhoneNumber(String phone) {
        // check if blank or smaller than 5
        if (phone == null ||phone.length() != 9) {
            return new ValidationResult(false, "The phone number needs to consist of 9 characters");
        }

        // check if starts with Yemeni number
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
        // Define a regular expression pattern to match only English or Arabic letters
        Pattern pattern = Pattern.compile("[a-zA-Z\u0600-\u06FF]+");

        // Check if the name matches the pattern
        if (!pattern.matcher(name).matches()) {
            return new ValidationResult(false, "The name can only contain English or Arabic letters");
        }

        return new ValidationResult(true, "");
    }

    public ValidationResult validateName2(String name) {
        // Check if the name is null or empty
        if (name == null || name.isEmpty()) {
            return new ValidationResult(false, "Name cannot be empty");
        }

        // Iterate over each character in the name
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            // Check if the character is valid
            if (!isValidNameCharacter(ch)) {
                return new ValidationResult(false, "The name can only contain English or Arabic letters and spaces");
            }
        }

        // Check if the name is a quad name (has four parts separated by spaces)
        String[] parts = name.split(" ");
        if (parts.length != 4) {
            return new ValidationResult(false, "The name must have four parts separated by spaces");
        }

        return new ValidationResult(true, "");
    }

    // Function to check if a string is null or empty
    private boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    // Function to check if a character is a valid English letter
    private boolean isEnglishLetter(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    // Function to check if a character is a valid Arabic letter
    private boolean isArabicLetter(char ch) {
        return ch >= '\u0600' && ch <= '\u06FF';
    }

    // Function to check if a character is a valid space character
    private boolean isSpace(char ch) {
        return ch == ' ';
    }

    // Function to check if a character is a valid name character (English letter, Arabic letter, or space)
    private boolean isValidNameCharacter(char ch) {
        return isEnglishLetter(ch) || isArabicLetter(ch) || isSpace(ch);
    }


}

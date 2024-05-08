package com.example.remittanceapp.domain.usecases;

import com.example.remittanceapp.domain.utils.ValidationResult;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

/**
 * This class provides methods to validate inputs from any form in the application.
 */
public class ValidateInputs {

    @Inject
    public ValidateInputs() {}

    /**
     * Validate the phone number and check if null or empty or
     *      contains 9 numbers also if the phone number is not from any Yemeni company.
     *
     * @param phone The phone number to validate.
     * @return A ValidationResult object indicating the result of the validation.
     */
    public ValidationResult validatePhoneNumber(String phone) {

        // Check if the phone number is null or has a length other than 9.
        if (phone == null || phone.length() != 9) {
            return new ValidationResult(false, "يجب ان يتكون الرقم من 9 ارقام. ");
        }

        // Define valid prefixes for Yemeni company phone numbers.
        List<String> validStarts = Arrays.asList("77", "78", "71", "70", "73");
        boolean startsWithValidPrefix = false;

        // Check if the phone number starts with any valid prefix.
        for (String prefix : validStarts) {
            if (phone.startsWith(prefix)) {
                startsWithValidPrefix = true;
                break;
            }
        }

        // If the phone number does not start with any valid prefix, return a validation failure.
        if (!startsWithValidPrefix) {
            return new ValidationResult(false, "يجب ان يكون الرقم ضمن احدى الشركات اليمنية");
        }

        // If the phone number passes all validations, return a successful validation result.
        return new ValidationResult(true, "");
    }


    /**
     * Validate the name if null or empty or Quad name, also if is not arabic or English.
     *
     * @param name The name to validate.
     * @return A ValidationResult object indicating the result of the validation.
     */
    public ValidationResult validateName(String name) {

        // Check if the name is null or empty.
        if (name == null || name.isEmpty()) {
            return new ValidationResult(false, "يجب الا يكون الاسم فارغا");
        }

        // Check each character in the name for validity.
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);

            // If any character is not a valid English, Arabic letter, or space, return a validation failure.
            if (!isValidNameCharacter(ch)) {
                return new ValidationResult(false, "الاسم يقبل فقط الحروف العربية او الانجليزية");
            }
        }

        // Split the name into parts separated by spaces.
        String[] parts = name.split(" ");

        // If the name does not have exactly four parts, return a validation failure.
        if (parts.length != 4) {
            return new ValidationResult(false, "يجب ادخال الاسم الرباعي يفصله المسافات");
        }

        // If the name passes all validations, return a successful validation result.
        return new ValidationResult(true, "");
    }

    /**
     * Checks if a character is an English letter.
     *
     * @param ch The character to check.
     * @return True if the character is an English letter, false otherwise.
     */
    private boolean isEnglishLetter(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    /**
     * Checks if a character is an Arabic letter.
     *
     * @param ch The character to check.
     * @return True if the character is an Arabic letter, false otherwise.
     */
    private boolean isArabicLetter(char ch) {
        return ch >= '\u0600' && ch <= '\u06FF';
    }

    /**
     * Checks if a character is a space.
     *
     * @param ch The character to check.
     * @return True if the character is a space, false otherwise.
     */
    private boolean isSpace(char ch) {
        return ch == ' ';
    }

    /**
     * Checks if a character is a valid character for a name (English letter, Arabic letter, or space).
     *
     * @param ch The character to check.
     * @return True if the character is a valid name character, false otherwise.
     */
    private boolean isValidNameCharacter(char ch) {
        return isEnglishLetter(ch) || isArabicLetter(ch) || isSpace(ch);
    }


}

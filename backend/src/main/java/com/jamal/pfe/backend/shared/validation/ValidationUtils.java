package com.jamal.pfe.backend.shared.validation;

public class ValidationUtils {

    public static boolean isValidEmail(String email) {
        return email != null && email.contains("@");
    }

    public static boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }
}
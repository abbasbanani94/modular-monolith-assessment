package com.modular_monolith.assessment1.shared.validators;

import com.modular_monolith.assessment1.shared.exceptions.AppException;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

public class ValueValidator {

    public static void assertNotEmpty(String value, Class<?> aClass) {
        if (value == null || value.trim().isEmpty()) {
            throw new AppException.BadRequestException(aClass.getSimpleName() + " cannot be empty");
        }
    }

    public static void assertWithinRange(Class<?> aClass, String value, int minLength, int maxLength) {
        if (value.length() < minLength || value.length() > maxLength) {
            throw new AppException.BadRequestException(aClass.getSimpleName() + " must be between " + minLength + " and " + maxLength + " characters");
        }
    }

    public static void assertValidFormat(String value, Pattern pattern, Class<?> aClass) {
        if (!pattern.matcher(value).matches()) {
            throw new AppException.BadRequestException(aClass.getSimpleName() + " has an invalid format");
        }
    }

    public static void assertNotInPast(Class<?> aClass, LocalDateTime dateTime) {
        if (dateTime.isBefore(LocalDateTime.now())) {
            throw new AppException.BadRequestException(
                    aClass.getSimpleName() + " must not be in the past. Received: " + dateTime);
        }
    }
}

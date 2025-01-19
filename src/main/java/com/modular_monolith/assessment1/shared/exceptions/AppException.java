package com.modular_monolith.assessment1.shared.exceptions;

public abstract class AppException extends RuntimeException {

    protected AppException(String message) {
        super(message);
    }

    protected AppException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Exception for requirement violations.
     */
    public static class RequirementException extends AppException {
        public RequirementException(String description) {
            super(description);
        }
    }

    /**
     * Exception for bad request errors.
     */
    public static class BadRequestException extends AppException {
        public BadRequestException(String description) {
            super("Bad Request: " + (description != null ? description : ""));
        }
    }

    public static class IllegalException extends AppException {
        public IllegalException(String description) {
            super("Bad Request: " + (description != null ? description : ""));
        }
    }

    /**
     * Exception for not found errors.
     */
    public static class NotFoundException extends AppException {
        public NotFoundException(String description) {
            super("Not Found: " + (description != null ? description : ""));
        }
    }
}

package com.example.demo.dto;

public class ErrorResponse {
    private final ErrorCode errorCode;
    private final String errorMessage;

    public ErrorResponse(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.errorMessage = errorCode.getMessage();
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

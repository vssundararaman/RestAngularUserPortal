package com.springrest.userportal.Exception;

import com.springrest.userportal.model.ErrorResponse;
import com.springrest.userportal.model.Errors;

public class RestApiException extends RuntimeException {

    private String sourceService;
    private String message;
    private String field;
    private ErrorResponse error;
    private String reasonCode;
    private String value;
    private Errors errors;

    public RestApiException(ErrorResponse error, String sourceService, String message, String reasonCode) {
        super(error.getResponseMessage());
        this.error = error;
        this.sourceService = sourceService;
        this.message = message;
        this.reasonCode = reasonCode;
    }

    public RestApiException(ErrorResponse error, String sourceService, String message, String field, String reasonCode) {
        this(error, sourceService, message, reasonCode);
        this.field = field;
    }

    public RestApiException(ErrorResponse error, Errors errors) {
        this.error = error;
        this.errors = errors;
    }

    public RestApiException(ErrorResponse error, String sourceService, String message, String field, String reasonCode, String value) {
        this(error, sourceService, message, reasonCode);
        this.field = field;
        this.value = value;
    }

    public RestApiException(Exception ex, ErrorResponse error, String sourceService, String message, String field, String reasonCode) {
        super(ex);
        this.error = error;
        this.sourceService = sourceService;
        this.message = message;
        this.field = field;
        this.reasonCode = reasonCode;
    }

    public ErrorResponse getError() {
        return this.error;
    }

    public Errors getErrors() {
        return this.errors;
    }

    public String getField() {
        return this.field;
    }

    public RestApiException setField(String field) {
        this.field = field;
        return this;
    }

    public String getMessage() {
        return this.message;
    }

    public String getReasonCode() {
        return this.reasonCode;
    }

    public String getSourceService() {
        return this.sourceService;
    }

    public String getValue() {
        return this.value;
    }

    public RestApiException setValue(String value) {
        this.value = value;
        return this;
    }


}

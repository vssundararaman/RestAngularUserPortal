package com.springrest.userportal.model;

public enum ErrorResponse {

    MULTIPLE_CHOICE(300, "TBD Redirection codes"),
    NOT_MODIFIED(304, "Resource not found"),
    BAD_REQUEST(400, "Bad Request"),
    NO_RESULT(404, "Resource not found"),
    PRECONDITION_FAILED(412, "Precondition failed"),
    UNSUPPORTED_MEDIA_TYPE(415, "Unsupported Media Type"),
    SERVER_ERROR(500, "Internal Server Error"),
    DEFAULT_ERRROR(500, "Internal Server Error"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403, "Forbidden"),
    NOT_IMPLEMENTED(501, "Not Implemented");

    private int responseCode;
    private String responseMessage;

    public int getResponseCode() {
        return this.responseCode;
    }

    public ErrorResponse setResponseCode(int responseCode) {
        this.responseCode = responseCode;
        return this;
    }

    public String getResponseMessage() {
        return this.responseMessage;
    }

    public ErrorResponse setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
        return this;
    }

    private ErrorResponse(int responseCode, String responseMessage) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }

    public static ErrorResponse getApiErrorResponse(int reasonCode) {
        switch(reasonCode) {
            case 300:
                return MULTIPLE_CHOICE;
            case 304:
                return NOT_MODIFIED;
            case 400:
                return BAD_REQUEST;
            case 401:
                return UNAUTHORIZED;
            case 403:
                return FORBIDDEN;
            case 404:
                return NO_RESULT;
            case 412:
                return PRECONDITION_FAILED;
            case 415:
                return UNSUPPORTED_MEDIA_TYPE;
            case 500:
                return SERVER_ERROR;
            default:
                return DEFAULT_ERRROR;
        }
    }
}

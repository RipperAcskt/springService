package com.example.springservice.exception;

import org.springframework.http.HttpStatus;

public class Exception extends java.lang.Exception {
    private String exception;
    private HttpStatus status;

    public Exception(String exception, HttpStatus status) {
        this.exception = exception;
        this.status = status;
    }

    public Exception(String exception) {
        this.exception = exception;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}

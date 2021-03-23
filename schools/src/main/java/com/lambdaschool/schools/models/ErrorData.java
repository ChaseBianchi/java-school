package com.lambdaschool.schools.models;

import java.util.Date;
import java.util.List;

public class ErrorData {
    private String title;
    private int status;
    private String detail;
    private Date timestamp;
    private String developerMessage;
    private List<ValidationErr> errors;

    public ErrorData() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }

    public List<ValidationErr> getErrors() {
        return errors;
    }

    public void setErrors(List<ValidationErr> errors) {
        this.errors = errors;
    }
}

package com.lambdaschool.schools.models;

public class ValidationErr {
    private String fieldname;
    private String message;

    public ValidationErr() {
    }

    public String getFieldname() {
        return fieldname;
    }

    public void setFieldname(String fieldname) {
        this.fieldname = fieldname;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

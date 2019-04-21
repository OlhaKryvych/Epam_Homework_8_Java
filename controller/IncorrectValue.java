package com.epam.controller;

public class IncorrectValue extends Exception {
    private String error = "";

    public IncorrectValue(String error) {
        this.error = error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String getMessage() {
        return error;
    }
}

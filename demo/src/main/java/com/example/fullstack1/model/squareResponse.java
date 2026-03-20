package com.example.fullstack1.model;

public class squareResponse {
    private double a;
    private String message;
    private double result;
    public squareResponse(double a, double result, String message) {
        this.a = a;
        this.result = result;
        this.message = message;
    }

    public double getA() {
        return a;
    }

    public String getMessage() {
        return message;
    }

    public double getResult() {
        return result;
    }
}
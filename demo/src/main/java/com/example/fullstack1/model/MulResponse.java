package com.example.fullstack1.model;

public class MulResponse {
    private double a;
    private double b;
    private double result;
    private String message;

    public MulResponse(double a, double b, double result, String message) {
        this.a = a;
        this.b = b;
        this.result = result;
        this.message = message;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }
}

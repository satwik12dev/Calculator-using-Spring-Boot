package com.example.fullstack1.model;

public class TrigoResponse {
    private double angle;
    private String message;
    private double result;

    public TrigoResponse(double angle, double result, String message) {
        this.angle = angle;
        this.result = result;
        this.message = message;
    }

    public double getAngle() {
        return angle;
    }

    public double getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }
}

package com.wit.challenge;

public class CalcRequest {

    private final String operation;
    private final float a;
    private final float b;
    private String result;

    public CalcRequest(String operation, float a, float b) {
        this.operation = operation;
        this.a = a;
        this.b = b;
    }

    public String getOperation() {
        return operation;
    }

    public float getA() {
        return a;
    }

    public float getB() {
        return b;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}

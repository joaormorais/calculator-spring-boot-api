package com.wit.challenge;

public class CalcRequest {

    private final String id;
    private final String operation;
    private final float a;
    private final float b;
    private float result;

    public CalcRequest(String id, String operation, float a, float b) {
        this.id = id;
        this.operation = operation;
        this.a = a;
        this.b = b;
    }

    public String getId() {
        return id;
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

    public float getResult() {
        return result;
    }

    public void setResult(float result) {
        this.result = result;
    }
}

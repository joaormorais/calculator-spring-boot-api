package com.wit.challenge;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CalcRequest {

    @JsonProperty("id")
    private final String id;

    @JsonProperty("operation")
    private final String operation;

    @JsonProperty("a")
    private final float a;

    @JsonProperty("b")
    private final float b;

    @JsonProperty("result")
    private float result;

    @JsonCreator
    public CalcRequest(@JsonProperty("id") String id, @JsonProperty("operation") String operation, @JsonProperty("a") float a, @JsonProperty("b") float b) {
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

    @Override
    public String toString() {
        return "CalcRequest{" +
                "id='" + id + '\'' +
                ", operation='" + operation + '\'' +
                ", a=" + a +
                ", b=" + b +
                ", result=" + result +
                '}';
    }
}

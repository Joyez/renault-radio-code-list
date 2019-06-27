package com.models.cars;

public class Car {
    protected String mark;

    public Car(String mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return mark;
    }
}

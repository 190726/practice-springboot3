package com.sk.todo.unit.beverage;

public class Americano implements Beverage {
    @Override
    public String getName() {
        return "americano";
    }

    @Override
    public int getPrice() {
        return 100;
    }
}

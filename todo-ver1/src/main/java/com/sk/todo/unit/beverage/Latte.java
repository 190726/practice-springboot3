package com.sk.todo.unit.beverage;

public class Latte implements Beverage {
    @Override
    public String getName() {
        return "latte";
    }

    @Override
    public int getPrice() {
        return 40000;
    }
}

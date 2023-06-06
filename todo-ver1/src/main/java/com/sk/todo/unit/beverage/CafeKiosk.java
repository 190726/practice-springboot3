package com.sk.todo.unit.beverage;

import com.sk.todo.unit.order.Order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CafeKiosk {
    private final List<Beverage> beverages = new ArrayList<>();

    public void add (Beverage bevarage) {
        beverages.add(bevarage);
    }

    public void remove(Beverage bevarage) {
        beverages.remove(bevarage);
    }

    public void clear(){
        beverages.clear();
    }

    public Integer totalCalculatePrice() {
        return  beverages.stream()
                .map(Beverage::getPrice)
                .reduce(Integer::sum)
                .orElse(0);
    }

    public Order createOrder() {
        return new Order(LocalDateTime.now(), beverages);
    }

}
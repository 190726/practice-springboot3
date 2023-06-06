package com.sk.todo.unit.beverage;

public class CafeKioskRunner {

    public static void main(String[] args) {
        final var cafeKiosk = new CafeKiosk();
        cafeKiosk.add(new Americano());
        cafeKiosk.add(new Latte());
        System.out.println("-----");
        System.out.println(
            cafeKiosk.totalCalculatePrice()
        );
    }
}

package com.coffee.simulation.models;

public class Ingredients {
    private String name;
    private int quantity;

    public Ingredients(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return this.name;
    }

    public int getQuantity() {
        return this.quantity;
    }
}

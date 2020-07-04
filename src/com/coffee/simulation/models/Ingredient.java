package com.coffee.simulation.models;

public class Ingredient {
    private String name;
    private Long quantity;

    public Ingredient(String name, Long quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return this.name;
    }

    public Long getQuantity() {
        return this.quantity;
    }
}

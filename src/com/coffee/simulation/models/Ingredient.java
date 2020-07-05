package com.coffee.simulation.models;

public class Ingredient {
    private final String name;
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

    private void updateQuantity(Long quantity) {
        this.quantity = this.quantity + quantity;
    }

    public void decreaseQuantity(Long usedQuantity) {
        updateQuantity(-1 * usedQuantity);
    }

    public void increaseQuantity(Long quantityAdded) {
        updateQuantity(quantityAdded);
    }

}

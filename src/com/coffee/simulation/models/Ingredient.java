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

    public synchronized boolean checkAndUpdateQuantity(Long quantity) {
        if (checkForAvailability(quantity)) {
            updateQuantity(quantity);
            return true;
        } else {
            return false;
        }
    }

    private boolean checkForAvailability(Long requiredQuantity) {
       return this.quantity >= requiredQuantity;
    }

    private void updateQuantity(Long usedQuantity) {
        this.quantity = this.quantity - usedQuantity;
    }
}

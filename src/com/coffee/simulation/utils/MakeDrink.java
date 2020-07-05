package com.coffee.simulation.utils;

import com.coffee.simulation.models.Beverage;
import com.coffee.simulation.models.Ingredient;

import java.util.ArrayList;

public class MakeDrink implements Runnable {
    Beverage beverage;
    ArrayList<Ingredient> inventory;

    public MakeDrink(Beverage beverage, ArrayList<Ingredient> inventory) {
        this.beverage = beverage;
        this.inventory = inventory;
    }

    @Override
    public void run() {
        checkAndUpdateQuantity(beverage, inventory);
    }

    synchronized public static void checkAndUpdateQuantity(Beverage beverage,
                                                           ArrayList<Ingredient> inventory) {
        System.out.println("Drink to be made: " + beverage.getName());
        if (checkForAvailability( beverage, inventory)) {
            updateQuantity( beverage, inventory);
        }
        System.out.println("Ingredients available after " + beverage.getName() + ":");
        for (Ingredient ingredient: inventory) {
            System.out.print(ingredient.getName()+ ": " + ingredient.getQuantity() + " ");
        }
        System.out.println();
    }

    private static boolean checkForAvailability(Beverage beverage,
                                                ArrayList<Ingredient> inventory) {
        for (Ingredient required: beverage.getrequiredIngredients()) {
            boolean isItemExists = false;
            for (Ingredient available: inventory) {
                if (required.getName().equals(available.getName())) {
                    isItemExists = true;
                    if (required.getQuantity() > available.getQuantity()) {
                        System.out.println("***" + beverage.getName() + " cannot be prepared because " + required.getName() + " is not available***");
                        return false;
                    }
                }
            }
            if (isItemExists == false) {
                System.out.println("***" + beverage.getName() + " cannot be prepared because " + required.getName() + " is not available***");
                return false;
            }
        }
        return true;
    }

    private static void updateQuantity(Beverage beverage, ArrayList<Ingredient> inventory) {
        for (Ingredient required: beverage.getrequiredIngredients()) {
            for (Ingredient available: inventory) {
                if (required.getName().equals(available.getName())) {
                    available.decreaseQuantity(required.getQuantity());
                }
            }
        }
        System.out.println("***" + beverage.getName() + " is prepared***");
    }
}

package com.coffee.simulation.models;

import java.util.ArrayList;

public class Beverage {
    private String name;
    private ArrayList<Ingredient> requiredIngredients;

    public Beverage(String name, ArrayList<Ingredient> requiredIngredients) {
        this.name = name;
        this.requiredIngredients = requiredIngredients;
    }

    public ArrayList<Ingredient> getrequiredIngredients() {
        return this.requiredIngredients;
    }

    public String getName() {
        return this.name;
    }
}

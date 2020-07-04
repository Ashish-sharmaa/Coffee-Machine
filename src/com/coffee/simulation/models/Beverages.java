package com.coffee.simulation.models;

import java.util.ArrayList;

public class Beverages {
    private String name;
    private ArrayList<Ingredients> requiredIngredients;

    public Beverages(String name, ArrayList<Ingredients> requiredIngredients) {
        this.name = name;
        this.requiredIngredients = requiredIngredients;
    }
}

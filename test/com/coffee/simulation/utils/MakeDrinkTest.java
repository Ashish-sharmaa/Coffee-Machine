package com.coffee.simulation.utils;

import com.coffee.simulation.models.Beverage;
import com.coffee.simulation.models.Ingredient;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MakeDrinkTest {
    @Test
    public void checkForAvailabilityWithAdequateIngredients() {
        Beverage beverage = new Beverage("hot_coffee",
                new ArrayList<>(Arrays.asList(
                        new Ingredient("milk", 400L),
                        new Ingredient("water", 200L),
                        new Ingredient("masala", 300L)
                )));
        ArrayList<Ingredient> inventory = new ArrayList<>(Arrays.asList(
                new Ingredient("milk", 400L),
                new Ingredient("water", 200L),
                new Ingredient("masala", 300L)
        ));
        boolean actualResult = MakeDrink.checkForAvailability(beverage, inventory);
        boolean expectedResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void checkForAvailabilityWithInadequateIngredients() {
        Beverage beverage = new Beverage("hot_coffee",
                new ArrayList<>(Arrays.asList(
                        new Ingredient("milk", 400L),
                        new Ingredient("water", 200L),
                        new Ingredient("masala", 300L)
                )));
        ArrayList<Ingredient> inventory = new ArrayList<>(Arrays.asList(
                new Ingredient("milk", 200L),
                new Ingredient("water", 400L),
                new Ingredient("masala", 700L)
        ));
        boolean actualResult = MakeDrink.checkForAvailability(beverage, inventory);
        boolean expectedResult = false;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void checkForAvailabilityWithMissingIngredients() {
        Beverage beverage = new Beverage("hot_coffee",
                new ArrayList<>(Arrays.asList(
                        new Ingredient("milk", 400L),
                        new Ingredient("water", 200L),
                        new Ingredient("masala", 300L)
                )));
        ArrayList<Ingredient> inventory = new ArrayList<>(Arrays.asList(
                new Ingredient("water", 400L),
                new Ingredient("masala", 700L)
        ));
        boolean actualResult = MakeDrink.checkForAvailability(beverage, inventory);
        boolean expectedResult = false;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void checkAndUpdateQuantityWithAdequateIngredients() {
        Beverage beverage = new Beverage("hot_coffee",
                new ArrayList<>(Arrays.asList(
                        new Ingredient("milk", 400L),
                        new Ingredient("water", 200L),
                        new Ingredient("masala", 300L)
                )));
        ArrayList<Ingredient> inventory = new ArrayList<>(Arrays.asList(
                new Ingredient("milk", 500L),
                new Ingredient("water", 400L),
                new Ingredient("masala", 700L)
        ));
        try {
            MakeDrink.checkAndUpdateQuantity(beverage, inventory);
        } catch (Exception e) {
            fail("Method checkAndUpdateQuantity should not throw exception: " + e.getMessage());
        }
    }

    @Test
    public void checkAndUpdateQuantityWithInadequateIngredients() {
        Beverage beverage = new Beverage("hot_coffee",
                new ArrayList<>(Arrays.asList(
                        new Ingredient("milk", 400L),
                        new Ingredient("water", 200L),
                        new Ingredient("masala", 300L)
                )));
        ArrayList<Ingredient> inventory = new ArrayList<>(Arrays.asList(
                new Ingredient("milk", 200L),
                new Ingredient("water", 400L),
                new Ingredient("masala", 700L)
        ));
        try {
            MakeDrink.checkAndUpdateQuantity(beverage, inventory);
        } catch (Exception e) {
            fail("Method checkAndUpdateQuantity should not throw exception: " + e.getMessage());
        }
    }

    @Test
    public void checkAndUpdateQuantityWithMissingIngredients() {
        Beverage beverage = new Beverage("hot_coffee",
                new ArrayList<>(Arrays.asList(
                        new Ingredient("milk", 400L),
                        new Ingredient("water", 200L),
                        new Ingredient("masala", 300L)
                )));
        ArrayList<Ingredient> inventory = new ArrayList<>(Arrays.asList(
                new Ingredient("milk", 500L),
                new Ingredient("masala", 700L)
        ));
        try {
            MakeDrink.checkAndUpdateQuantity(beverage, inventory);
        } catch (Exception e) {
            fail("Method checkAndUpdateQuantity should not throw exception: " + e.getMessage());
        }
    }

    @Test
    public void updateQuantity() {
        Beverage beverage = new Beverage("hot_coffee",
                new ArrayList<>(Arrays.asList(
                        new Ingredient("milk", 400L),
                        new Ingredient("water", 200L),
                        new Ingredient("masala", 300L)
                )));
        ArrayList<Ingredient> inventory = new ArrayList<>(Arrays.asList(
                new Ingredient("milk", 500L),
                new Ingredient("water", 400L),
                new Ingredient("masala", 700L)
        ));
        try {
            MakeDrink.updateQuantity(beverage, inventory);
        } catch (Exception e) {
            fail("Method updateQuantity should not throw exception: " + e.getMessage());
        }
    }
}
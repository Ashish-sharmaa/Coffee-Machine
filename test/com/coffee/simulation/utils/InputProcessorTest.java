package com.coffee.simulation.utils;

import com.coffee.simulation.models.Beverage;
import com.coffee.simulation.models.Ingredient;
import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class InputProcessorTest {
    @Test
    public void getOutLetCountForValidInput() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("count_n", 34L);
        Long actualResult = InputProcessor.getOutLetCount(jsonObject);
        Long expectedResult = 34L;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getOutLetCountForMissingInput() {
        JSONObject jsonObject = new JSONObject();
        try {
            InputProcessor.getOutLetCount(jsonObject);
            fail("getOutLetCount method should throw exception in case of string inputs");
        } catch(Exception e) {
            String expectedResult = "count_n is not Integer";
            String actualResult = e.getMessage();
            assertEquals(expectedResult, actualResult);
        }}

    @Test
    public void getOutLetCountForStringInput() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("count_n", "df");
        try {
            InputProcessor.getOutLetCount(jsonObject);
            fail("getOutLetCount method should throw exception in case of string inputs");
        } catch(Exception e) {
            String expectedResult = "count_n is not Integer";
            String actualResult = e.getMessage();
            assertEquals(expectedResult, actualResult);
        }
    }

    @Test
    public void getBeverages() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cold_coffee", new JSONObject());
        jsonObject.put("cold_tea", new JSONObject());
        jsonObject.put("hot_coffee", new JSONObject());
        ArrayList<Beverage> actualResult = InputProcessor.getBeverages(jsonObject);
        ArrayList<Beverage> expectedResult = new ArrayList<>(Arrays.asList(
                new Beverage("cold_coffee", new ArrayList<Ingredient>()),
                new Beverage("cold_tea", new ArrayList<Ingredient>()),
                new Beverage("hot_coffee", new ArrayList<Ingredient>())
        ));
        assertEquals(expectedResult.size(), actualResult.size());
        for (Beverage beverage: actualResult) {
            assertTrue(beverageExists(beverage.getName(), expectedResult));
        }
    }

    private boolean beverageExists(String name, @NotNull ArrayList<Beverage> list) {
        for (Beverage item: list) {
            if (item.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void getIngredients() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("milk", 400L);
        jsonObject.put("water", 200L);
        jsonObject.put("masala", 300L);
        ArrayList<Ingredient> actualResult = InputProcessor.getIngredients(jsonObject);
        ArrayList<Ingredient> expectedResult = new ArrayList<>(Arrays.asList(
                new Ingredient("milk", 400L),
                new Ingredient("water", 200L),
                new Ingredient("masala", 300L)
        ));
        assertEquals(expectedResult.size(), actualResult.size());
        for (Ingredient ingredient: actualResult) {
            assertTrue(ingredientExists(ingredient.getName(), expectedResult));
        }
    }

    private boolean ingredientExists(String name, @NotNull ArrayList<Ingredient> list) {
        for (Ingredient item: list) {
            if (item.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
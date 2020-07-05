package com.coffee.simulation.utils;

import com.coffee.simulation.models.Beverage;
import com.coffee.simulation.models.Ingredient;
import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InputProcessor {
    public static JSONObject parseJson(String path, String key) throws IOException, ParseException {
        Object obj = new JSONParser().parse(new FileReader(path));
        return (JSONObject) ((JSONObject) obj).get(key);
    }

    public static Long getOutLetCount(@NotNull JSONObject outlets) {
        if (outlets.get("count_n") instanceof Long) {
            return (Long) outlets.get("count_n");
        } else {
            throw new IllegalStateException("count_n is not Integer");
        }
    }

    public static @NotNull ArrayList<Ingredient> getIngredients(@NotNull JSONObject inputIngredients) {
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        for (Object name : inputIngredients.keySet()) {
            ingredients.add(new Ingredient((String) name, (Long) inputIngredients.get(name)));
        }
        return ingredients;
    }

    public static @NotNull ArrayList<Beverage> getBeverages(@NotNull JSONObject inputBeverages) {
        ArrayList<Beverage> beverages = new ArrayList<>();
        for (Object beverage : inputBeverages.keySet()) {
            beverages.add(new Beverage((String) beverage,
                    getIngredients((JSONObject) inputBeverages.get(beverage))));
        }
        return beverages;
    }
}

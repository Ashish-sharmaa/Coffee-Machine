package com.coffee.simulation;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.coffee.simulation.models.Beverage;
import com.coffee.simulation.models.Ingredient;
import com.coffee.simulation.utils.Constants;
import com.coffee.simulation.utils.InputProcessor;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class DrinkMachine {
    public static void main(String[] args) throws IOException, ParseException {
        JSONObject machine = InputProcessor.parseJson(Constants.inputJsonPath, "machine");
        ArrayList<Ingredient> inventory = InputProcessor.getIngredients((JSONObject) machine.get("total_items_quantity"));
        ArrayList<Beverage> beverages = InputProcessor.getBeverages((JSONObject) machine.get("beverages"));
        Long outletCount = InputProcessor.getOutLetCount((JSONObject) machine.get("outlets"));
    }
}

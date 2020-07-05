package com.coffee.simulation;

import com.coffee.simulation.models.Beverage;
import com.coffee.simulation.models.Ingredient;
import com.coffee.simulation.utils.Constants;
import com.coffee.simulation.utils.CustomerSequenceGenerator;
import com.coffee.simulation.utils.InputProcessor;
import com.coffee.simulation.utils.MakeDrink;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class DrinkMachine {
    public static void main(String[] args) throws IOException, ParseException, InterruptedException {
        JSONObject machine = InputProcessor.parseJson(Constants.inputJsonPath, "machine");

        ArrayList<Ingredient> inventory = InputProcessor.getIngredients((JSONObject) machine.get("total_items_quantity"));
        ArrayList<Beverage> beverages = InputProcessor.getBeverages((JSONObject) machine.get("beverages"));
        Long outletCount = InputProcessor.getOutLetCount((JSONObject) machine.get("outlets"));

        ArrayList<ArrayList<Integer>> customerSequence = CustomerSequenceGenerator.getCustomerSequence(outletCount, beverages);

        prepareDrink(customerSequence, inventory, beverages);
    }

    private static void prepareDrink(ArrayList<ArrayList<Integer>> customerSequence, ArrayList<Ingredient> inventory,
                                     ArrayList<Beverage> beverages) throws InterruptedException {
        for (ArrayList<Integer> currentSequence : customerSequence) {
            for (Integer drinkIndex : currentSequence) {
                if (drinkIndex > -1) {
                    new Thread(new MakeDrink(beverages.get(drinkIndex), inventory)).start();
                }
            }
            TimeUnit.SECONDS.sleep(2);
            System.out.println("***Waiting for next lot of customers***");
        }
    }
}

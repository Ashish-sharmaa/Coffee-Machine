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
/*
    Assumption:
           1. Number of instances a group of consumers can arrive at any point is generated randomly with modulo 10
           2. Multiple outlets can provide same type of drinks simultaneously.
           3. A sleep of 2 seconds is added to indicate time interval between two consecutive sets.
           4. Indexing is 0th based
 */
public class DrinkMachine {
    public static void main(String[] args) throws IOException, ParseException, InterruptedException {
        JSONObject machine = InputProcessor.parseJson(Constants.inputJsonPath, Constants.machine);

        Long outletCount = InputProcessor.getOutLetCount((JSONObject) machine.get(Constants.outlet));
        ArrayList<Ingredient> inventory = InputProcessor.getIngredients((JSONObject) machine.get(Constants.totalItemsQuantity));
        ArrayList<Beverage> beverages = InputProcessor.getBeverages((JSONObject) machine.get(Constants.beverages));

        /* Prepare the incoming sequence of customer
           Ex: For Machine having 3 outlets
           [
            ["hot_coffee", "cold_coffee", "hot_milk"],
            ["cold_coffee", "hot_milk"],
            ["cold_coffee", "cold_coffee"],
            ["hot_water"]
           ]
           Explanation: First three simultaneous orders of hot_coffee, cold_coffee and hot_milk,
                        then, two simultaneous orders of cold_coffee and hot_milk,
                        then, two simultaneous orders of cold_coffee
                        lastly a single order of hot_water
        */
        ArrayList<ArrayList<Integer>> customerSequence = CustomerSequenceGenerator.getCustomerSequence(outletCount, beverages);

        prepareDrink(customerSequence, inventory, beverages);
    }

    private static void prepareDrink(ArrayList<ArrayList<Integer>> customerSequence, ArrayList<Ingredient> inventory,
                                     ArrayList<Beverage> beverages) throws InterruptedException {
        for (ArrayList<Integer> currentSequence : customerSequence) {
            for (Integer drinkIndex : currentSequence) {
                new Thread(new MakeDrink(beverages.get(drinkIndex), inventory)).start();
            }
            /* Waiting for next set of customers to arrive */
            TimeUnit.SECONDS.sleep(2);
            System.out.println("***Waiting for next lot of customers***");
        }
    }
}

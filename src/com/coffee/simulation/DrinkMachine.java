package com.coffee.simulation;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import com.coffee.simulation.models.Beverages;
import com.coffee.simulation.models.Ingredients;
import com.coffee.simulation.utils.Constants;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DrinkMachine {
    private static int outletCount;
    private static ArrayList<Beverages> beverages;
    private static ArrayList<Ingredients> availableIngredients;

    public static void main(String[] args) throws IOException, ParseException {
        Object obj = new JSONParser().parse(new FileReader(Constants.inputJsonPath));
        JSONObject machine = (JSONObject) ((JSONObject) obj).get("machine");
        System.out.println(machine);
    }
}

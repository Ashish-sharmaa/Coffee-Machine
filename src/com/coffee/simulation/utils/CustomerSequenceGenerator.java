package com.coffee.simulation.utils;

import com.coffee.simulation.models.Beverage;

import java.util.ArrayList;
import java.util.Random;

public class CustomerSequenceGenerator {
    public static ArrayList<ArrayList<Integer>> getCustomerSequence(Long outLetCount, ArrayList<Beverage> beverages) {
        Random rand = new Random();
        int sets = rand.nextInt(10) + 1;
        int drinkCount = beverages.size();
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        for (int iter = 1; iter <= sets; iter++) {
            ArrayList<Integer> inputDrinks = new ArrayList<>();
            for (int innerIter = 0; innerIter < outLetCount; innerIter++) {
                int drinkNumber = rand.nextInt(drinkCount + 1) - 1;
                inputDrinks.add(drinkNumber);
            }
            input.add(inputDrinks);
        }
        System.out.println("Number of lots customers came in: " + input.size());
        System.out.println("[");
        for (ArrayList<Integer> list : input) {
            System.out.print(" [");
            for (Integer innerIter : list) {
                if (innerIter > -1) {
                    System.out.print(beverages.get(innerIter).getName() + ",");
                }
            }
            System.out.println("],");
        }
        System.out.println("]");
        return input;
    }
}

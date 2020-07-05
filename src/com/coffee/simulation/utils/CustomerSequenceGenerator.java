package com.coffee.simulation.utils;

import com.coffee.simulation.models.Beverage;

import java.util.ArrayList;
import java.util.Random;

public class CustomerSequenceGenerator {
    /* Generate the sequence of customers that arrive at the drink counter */
    public static ArrayList<ArrayList<Integer>> getCustomerSequence(Long outLetCount, ArrayList<Beverage> beverages) {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();

        /* Assumption: Total number of customers-set came are in between [1, 10] */
        Random rand = new Random();
        int sets = rand.nextInt(Constants.customerSetBound) + 1;

        for (int iter = 1; iter <= sets; iter++) {
            ArrayList<Integer> consecutiveDrinks = new ArrayList<>();
            for (int innerIter = 0; innerIter < outLetCount; innerIter++) {
                /* Indices are generated from [-1, total-number-of-drinks-possible)
                   Index: -1 indicates no order.
                   Ex: a set of [2, 1, 0] indicates simultaneous order of drink-2, drink-1 and drink-0
                       whereas a set of [2, -1, 4] indicates simultaneous order of drink-2 and drink-4
                */
                int drinkNumber = rand.nextInt(beverages.size() + 1) - 1;
                if (drinkNumber > -1) {
                    consecutiveDrinks.add(drinkNumber);
                }
            }
            input.add(consecutiveDrinks);
        }

        System.out.println("Number of lots customers came in: " + input.size());
        System.out.println("[");
        for (ArrayList<Integer> list : input) {
            System.out.print(" [");
            for (Integer innerIter : list) {
                System.out.print(beverages.get(innerIter).getName() + ",");
            }
            System.out.println("],");
        }
        System.out.println("]");

        return input;
    }
}

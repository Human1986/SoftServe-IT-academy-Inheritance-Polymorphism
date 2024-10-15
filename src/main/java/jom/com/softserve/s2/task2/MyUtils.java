package jom.com.softserve.s2.task2;

import java.util.*;

interface DrinkReceipt {

    String getName();

    DrinkReceipt addComponent(String componentName, int componentCount);
}

interface DrinkPreparation {
    Map<String, Integer> makeDrink();
}

interface Rating {
    int getRating();
}

class Coffee implements DrinkReceipt, DrinkPreparation, Rating {
    private final String name;
    private final int rating;
    private final Map<String, Integer> ingredients;

    public Coffee(String name, int rating) {
        this.name = name;
        this.rating = rating;
        this.ingredients = new HashMap<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public DrinkReceipt addComponent(String componentName, int componentCount) {
        ingredients.put(componentName, componentCount);
        return new Coffee(name, rating);
    }

    @Override
    public Map<String, Integer> makeDrink() {
        return new HashMap<>(Map.of("Water", 100, "Arabica", 20));
    }

    @Override
    public int getRating() {
        return rating;
    }

    public Map<String, Integer> getIngredients() {
        return new HashMap<>();
    }
}

class Espresso extends Coffee {

    public Espresso(String name, int rating) {
        super(name, rating);
    }

    @Override
    public Map<String, Integer> makeDrink() {

        Map<String, Integer> components = new HashMap<>(super.makeDrink());
        components.put("Water", 50);
        return components;
    }

}

class Cappuccino extends Coffee {

    public Cappuccino(String name, int rating) {
        super(name, rating);
    }

    @Override
    public Map<String, Integer> makeDrink() {
        Map<String, Integer> components = new HashMap<>(super.makeDrink());
        components.put("Milk", 50);
        return components;
    }
}

public class MyUtils {

    public Map<String, Double> averageRating(List<Coffee> coffees) {

        if (coffees.size() == 1) {
            Coffee coffee = coffees.get(0);
            return new HashMap<>(Map.of(coffee.getName(), (double) coffee.getRating()));
        }

        if (! coffees.isEmpty()) {
            int sumRatingEspresso = 0, sumRatingCappuccino = 0, sumRatingCoffee = 0;
            int espresso = 0, capuccino = 0, coffee = 0;

            for (Coffee c : coffees) {
                if (c.getName().equals("Espresso")) {
                    sumRatingEspresso += c.getRating();
                    espresso++;
                } else if (c.getName().equals("Cappuccino")) {
                    sumRatingCappuccino += c.getRating();
                    capuccino++;
                } else if (c.getName().equals("Coffee")) {
                    sumRatingCoffee += c.getRating();
                    coffee++;
                }
            }


            Map<String, Double> result = new HashMap<>();
            if (capuccino > 1) {
                result.put("Cappuccino", (double) sumRatingCappuccino / 2);
            } else {
                result.put("Cappuccino", (double) sumRatingCappuccino);
            }


            if (espresso > 1) {
                result.put("Espresso", (double) sumRatingEspresso / 2);
            } else {
                result.put("Espresso", (double) sumRatingEspresso);
            }

            if (coffee > 1) {
                result.put("Coffee", (double) sumRatingCoffee / 2);
            } else {
                result.put("Coffee", (double) sumRatingCoffee);
            }

            return result;
        }
        return new HashMap<>();
    }
}


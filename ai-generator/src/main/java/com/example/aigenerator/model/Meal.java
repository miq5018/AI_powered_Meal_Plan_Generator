package com.example.aigenerator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents a meal in a meal plan, including its name, dishes, and portion size.
 */
public class Meal {
    @JsonProperty("meal_name")
    private String mealName;
    @JsonProperty("dishes")
    private String dishes;
    @JsonProperty("portion_size")
    private String portionSize;
    
    /**
     * Constructs a new instance of Meal with default values.
     */
    public Meal() {
    }

    /**
     * Constructs a new instance of Meal with the specified values.
     * 
     * @param mealName The name of the meal.
     * @param dishes The dishes included in the meal.
     * @param portionSize The portion size of the meal.
     */
    public Meal(String mealName, String dishes, String portionSize) {
        this.mealName = mealName;
        this.dishes = dishes;
        this.portionSize = portionSize;
    }

    /**
     * Gets the name of the meal.
     * 
     * @return The name of the meal.
     */
    public String getMealName() {
        return mealName;
    }

    /**
     * Sets the name of the meal.
     * 
     * @param mealName The name of the meal to set.
     */
    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    /**
     * Gets the dishes included in the meal.
     * 
     * @return The dishes included in the meal.
     */
    public String getDishes() {
        return dishes;
    }

    /**
     * Sets the dishes included in the meal.
     * 
     * @param dishes The dishes to set.
     */
    public void setDishes(String dishes) {
        this.dishes = dishes;
    }

    /**
     * Gets the portion size of the meal.
     * 
     * @return The portion size of the meal.
     */
    public String getPortionSize() {
        return portionSize;
    }

    /**
     * Sets the portion size of the meal.
     * 
     * @param portionSize The portion size to set.
     */
    public void setPortionSize(String portionSize) {
        this.portionSize = portionSize;
    }
}

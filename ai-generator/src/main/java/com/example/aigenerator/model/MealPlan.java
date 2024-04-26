package com.example.aigenerator.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents a meal plan consisting of meals, snacks, and daily total nutrition information.
 */
public class MealPlan {
    @JsonProperty("meals")
    private List<Meal> meals;
    @JsonProperty("snacks")
    private List<Snack> snacks;
    @JsonProperty("daily_total")
    private NutritionInfo dailyTotal;

    /**
     * Constructs a new instance of MealPlan with default values.
     */
    public MealPlan() {
    }

    /**
     * Constructs a new instance of MealPlan with the specified values.
     * 
     * @param meals The list of meals in the meal plan.
     * @param snacks The list of snacks in the meal plan.
     * @param dailyTotal The daily total nutrition information for the meal plan.
     */
    public MealPlan(List<Meal> meals, List<Snack> snacks, NutritionInfo dailyTotal){
        this.meals = meals;
        this.dailyTotal = dailyTotal;
        this.snacks = snacks;
    }

    /**
     * Gets the list of meals in the meal plan.
     * 
     * @return The list of meals in the meal plan.
     */
    public List<Meal> getMeals() {
        return meals;
    }

    /**
     * Sets the list of meals in the meal plan.
     * 
     * @param meals The list of meals to set.
     */
    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    /**
     * Gets the list of snacks in the meal plan.
     * 
     * @return The list of snacks in the meal plan.
     */
    public List<Snack> getSnacks() {
        return snacks;
    }

    /**
     * Sets the list of snacks in the meal plan.
     * 
     * @param snacks The list of snacks to set.
     */
    public void setSnacks(List<Snack> snacks) {
        this.snacks = snacks;
    }

    /**
     * Gets the daily total nutrition information for the meal plan.
     * 
     * @return The daily total nutrition information for the meal plan.
     */
    public NutritionInfo getDailyTotal() {
        return dailyTotal;
    }

    /**
     * Sets the daily total nutrition information for the meal plan.
     * 
     * @param dailyTotal The daily total nutrition information to set.
     */
    public void setDailyTotal(NutritionInfo dailyTotal) {
        this.dailyTotal = dailyTotal;
    }
}

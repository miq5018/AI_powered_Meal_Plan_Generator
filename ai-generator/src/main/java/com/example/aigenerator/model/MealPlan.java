package com.example.aigenerator.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MealPlan {
    @JsonProperty("meals")
    private List<Meal> meals;
    @JsonProperty("snacks")
    private List<Snack> snacks;
    @JsonProperty("daily_total")
    private NutritionInfo dailyTotal;


    public MealPlan() {
    }

    public MealPlan(List<Meal> meals, List<Snack> snacks, NutritionInfo dailyTotal){
        this.meals = meals;
        this.dailyTotal = dailyTotal;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public List<Snack> getSnacks() {
        return snacks;
    }

    public void setSnacks(List<Snack> snacks) {
        this.snacks = snacks;
    }


    public NutritionInfo getDailyTotal() {
        return dailyTotal;
    }

    public void setDailyTotal(NutritionInfo dailyTotal) {
        this.dailyTotal = dailyTotal;
    }

}

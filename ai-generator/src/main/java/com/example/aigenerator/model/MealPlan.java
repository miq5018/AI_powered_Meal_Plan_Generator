package com.example.aigenerator.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MealPlan {
    @JsonProperty("meal_plan")
    private List<Meal> mealPlan;
    @JsonProperty("daily_total")
    private NutritionInfo dailyTotal;


    public MealPlan() {
    }

    public MealPlan(List<Meal> mealPlan, NutritionInfo dailyTotal){
        this.mealPlan = mealPlan;
        this.dailyTotal = dailyTotal;
    }

    public List<Meal> getMealPlan() {
        return mealPlan;
    }

    public void setMealPlan(List<Meal> mealPlan) {
        this.mealPlan = mealPlan;
    }

    public NutritionInfo getDailyTotal() {
        return dailyTotal;
    }

    public void setDailyTotal(NutritionInfo dailyTotal) {
        this.dailyTotal = dailyTotal;
    }

}

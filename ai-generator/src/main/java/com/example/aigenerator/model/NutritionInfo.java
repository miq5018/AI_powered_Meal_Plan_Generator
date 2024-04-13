package com.example.aigenerator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NutritionInfo {
    @JsonProperty("calories")
    private String calories;
    @JsonProperty("protein")
    private String protein;
    @JsonProperty("fiber")
    private String fiber;
    @JsonProperty("carbs")
    private String carbs;
    @JsonProperty("fat")
    private String fat;

    public NutritionInfo() {
    }

    public NutritionInfo(String calories, String protein, String fiber, String carbs, String fat){
        this.calories = calories;
        this.protein = protein;
        this.fiber = fiber;
        this.carbs = carbs;
        this.fat = fat;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public String getFiber() {
        return fiber;
    }

    public void setFiber(String fiber) {
        this.fiber = fiber;
    }

    public String getCarbs() {
        return carbs;
    }

    public void setCarbs(String carbs) {
        this.carbs = carbs;
    }

    public String getFat() {
        return fat;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }
    
}

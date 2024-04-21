package com.example.aigenerator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents nutrition information including calories, protein, fiber, carbs, and fat.
 */
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

    /**
     * Constructs a new instance of NutritionInfo with default values.
     */
    public NutritionInfo() {
    }

    /**
     * Constructs a new instance of NutritionInfo with the specified values.
     * 
     * @param calories The calories content of the meal plan.
     * @param protein The protein content of the meal plan.
     * @param fiber The fiber content of the meal plan.
     * @param carbs The carbohydrates content of the meal plan.
     * @param fat The fat content of the meal plan. 
     */
    public NutritionInfo(String calories, String protein, String fiber, String carbs, String fat){
        this.calories = calories;
        this.protein = protein;
        this.fiber = fiber;
        this.carbs = carbs;
        this.fat = fat;
    }

    /**
     * Gets the calories content of the meal plan.
     * 
     * @return The calories content of the meal plan.
     */
    public String getCalories() {
        return calories;
    }

    /**
     * Sets the calories content of the meal plan.
     * 
     * @param calories The calories content to set.
     */
    public void setCalories(String calories) {
        this.calories = calories;
    }

    /**
     * Gets the protein content of the meal plan.
     * 
     * @return The protein content of the meal plan.
     */
    public String getProtein() {
        return protein;
    }

    /**
     * Sets the protein content of the meal plan.
     * 
     * @param protein The protein content to set.
     */
    public void setProtein(String protein) {
        this.protein = protein;
    }

    /**
     * Gets the fiber content of the meal plan.
     * 
     * @return The fiber content of the meal plan.
     */
    public String getFiber() {
        return fiber;
    }

    /**
     * Sets the fiber content of the meal plan.
     * 
     * @return The fiber content to set.
     */
    public void setFiber(String fiber) {
        this.fiber = fiber;
    }

    /**
     * Gets the carbohydrate content of the meal plan.
     * 
     * @return The carbohydrate content of the meal plan.
     */
    public String getCarbs() {
        return carbs;
    }

    /**
     * Sets the carbohydrate content of the meal plan.
     * 
     * @param carbs The carbohydrate content to set.
     */
    public void setCarbs(String carbs) {
        this.carbs = carbs;
    }

    /**
     * Gets the fat content of the meal plan.
     * 
     * @return The fat content of the meal plan.
     */
    public String getFat() {
        return fat;
    }

    /**
     * Sets the fat content of the meal plan.
     * @param fat The fat content to set.
     */
    public void setFat(String fat) {
        this.fat = fat;
    }
}

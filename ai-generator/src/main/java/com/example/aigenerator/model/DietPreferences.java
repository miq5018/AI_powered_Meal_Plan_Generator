package com.example.aigenerator.model;

public class DietPreferences {
    private String dietType;
    private String cuisine;
    private int calories;
    private String mealTimeString;
    private String snackTimeString;
    private String allergySelectedItems;
    private String dislikeSelectedItems;
    
    public DietPreferences() {
    }

    public DietPreferences(String dietType, String cuisine, int calories, String mealTimeString, String snackTimeString,
            String allergySelectedItems, String dislikeSelectedItems) {
        this.dietType = dietType;
        this.cuisine = cuisine;
        this.calories = calories;
        this.mealTimeString = mealTimeString;
        this.snackTimeString = snackTimeString;
        this.allergySelectedItems = allergySelectedItems;
        this.dislikeSelectedItems = dislikeSelectedItems;
    }

    public String getDietType() {
        return dietType;
    }

    public void setDietType(String dietType) {
        this.dietType = dietType;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getMealTimeString() {
        return mealTimeString;
    }

    public void setMealTimeString(String mealTimeString) {
        this.mealTimeString = mealTimeString;
    }

    public String getSnackTimeString() {
        return snackTimeString;
    }

    public void setSnackTimeString(String snackTimeString) {
        this.snackTimeString = snackTimeString;
    }

    public String getAllergySelectedItems() {
        return allergySelectedItems;
    }

    public void setAllergySelectedItems(String allergySelectedItems) {
        this.allergySelectedItems = allergySelectedItems;
    }

    public String getDislikeSelectedItems() {
        return dislikeSelectedItems;
    }

    public void setDislikeSelectedItems(String dislikeSelectedItems) {
        this.dislikeSelectedItems = dislikeSelectedItems;
    }
    
}

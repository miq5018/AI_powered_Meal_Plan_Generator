package com.example.aigenerator.model;

/**
 * Represents the diet preferences of a user, including diet type, cuisine preference,
 * daily calorie limit, meal and snack times, as well as selected items for allergies/intolererence
 * and dislikes.
 */
public class DietPreferences {
    private String dietType;
    private String cuisine;
    private int calories;
    private String mealTimeString;
    private String snackTimeString;
    private String allergySelectedItems;
    private String dislikeSelectedItems;
    
    /**
     * Constructs a new instance of DietPreferences with default values.
     */
    public DietPreferences() {
    }

    /**
     * Constructs a new instance of DietPreferences with the specified values.
     * 
     * @param dietType The type of diet preferred by the user.
     * @param cuisine The preferred cuisine type.
     * @param calories The daily calorie needs for the user.
     * @param mealTimeString The frequency of meals in a day.
     * @param snackTimeString The frequency of snacks in a day.
     * @param allergySelectedItems The items that the user is allergic to or is intolerent with.
     * @param dislikeSelectedItems The items that the user dislikes.
     */
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

    /**
     * Gets the type of diet preferred by the user.
     * 
     * @return The diet type.
     */
    public String getDietType() {
        return dietType;
    }

    /**
     * Sets the type of diet preferred by the user.
     * 
     * @param dietType The diet type to set.
     */
    public void setDietType(String dietType) {
        this.dietType = dietType;
    }

    /**
     * Gets the preferred cuisine type.
     * 
     * @return The preferred cuisine.
     */
    public String getCuisine() {
        return cuisine;
    }

    /**
     * Sets the preferred cuisine type.
     * 
     * @param cuisine The cuisine to set.
     */
    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    /**
     * Gets the daily calorie needs for the user.
     * 
     * @return The daily calorie needs.
     */
    public int getCalories() {
        return calories;
    }

    /**
     * Sets the daily calorie needs for the user.
     * 
     * @param calories The daily calorie needs to set.
     */
    public void setCalories(int calories) {
        this.calories = calories;
    }

    /**
     * Gets the frequency of meals in a day.
     * 
     * @return The frequency of meals in a day.
     */
    public String getMealTimeString() {
        return mealTimeString;
    }

    /**
     * Sets the frequency of meals in a day.
     * @param mealTimeString The frequency of meals in a day to set.
     */
    public void setMealTimeString(String mealTimeString) {
        this.mealTimeString = mealTimeString;
    }

    /**
     * Gets the frequency of snacks in a day.
     * 
     * @return The frequency of snacks in a day.
     */
    public String getSnackTimeString() {
        return snackTimeString;
    }

    /**
     * Sets the frequency of snacks in a day.
     * @param snackTimeString The frequency of snacks in a day to set.
     */
    public void setSnackTimeString(String snackTimeString) {
        this.snackTimeString = snackTimeString;
    }

    /**
     * Gets the items that the user is allergic to or is intolerent with.
     * 
     * @return The items that the user is allergic to or is intolerent with.
     */
    public String getAllergySelectedItems() {
        return allergySelectedItems;
    }

    /**
     * Sets the items that the user is allergic to or is intolerent with.
     * @param allergySelectedItems The items that the user is allergic to or is intolerent with to set
     */
    public void setAllergySelectedItems(String allergySelectedItems) {
        this.allergySelectedItems = allergySelectedItems;
    }

    /**
     * Gets the items that the user dislikes.
     * 
     * @return The selected dislikes.
     */
    public String getDislikeSelectedItems() {
        return dislikeSelectedItems;
    }

    /**
     * Sets the items that the user dislikes.
     * @param dislikeSelectedItems the items that the user dislikes to set.
     */
    public void setDislikeSelectedItems(String dislikeSelectedItems) {
        this.dislikeSelectedItems = dislikeSelectedItems;
    }
}

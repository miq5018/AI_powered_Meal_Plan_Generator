package com.example.aigenerator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Meal {
    @JsonProperty("meal_name")
    private String mealName;
    @JsonProperty("dishes")
    private String dishes;
    @JsonProperty("portion_size")
    private String portionSize;
    
    public Meal() {
    }

    public Meal(String mealName, String dishes, String portionSize) {
        this.mealName = mealName;
        this.dishes = dishes;
        this.portionSize = portionSize;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getDishes() {
        return dishes;
    }

    public void setDishes(String dishes) {
        this.dishes = dishes;
    }

    public String getPortionSize() {
        return portionSize;
    }

    public void setPortionSize(String portionSize) {
        this.portionSize = portionSize;
    }



}

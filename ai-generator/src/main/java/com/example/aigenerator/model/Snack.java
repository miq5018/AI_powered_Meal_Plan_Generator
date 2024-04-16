package com.example.aigenerator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Snack {
     @JsonProperty("snack_name")
    private String snackName;
    @JsonProperty("dishes")
    private String dishes;
    @JsonProperty("portion_size")
    private String portionSize;
    
    public Snack(String snackName, String dishes, String portionSize) {
        this.snackName = snackName;
        this.dishes = dishes;
        this.portionSize = portionSize;
    }

    public Snack() {
    }

    public String getSnackName() {
        return snackName;
    }

    public void setSnackName(String snackName) {
        this.snackName = snackName;
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

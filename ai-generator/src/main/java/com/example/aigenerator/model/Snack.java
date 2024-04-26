package com.example.aigenerator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents a snack containing its name, dishes, and portion size.
 */
public class Snack {

  @JsonProperty("snack_name")
  private String snackName;
  @JsonProperty("dishes")
  private String dishes;
  @JsonProperty("portion_size")
  private String portionSize;

  /**
   * Constructs a new instance of Snack with default values.
   */
  public Snack() {
  }

  /**
   * Constructs a new instance of Snack with the specified values.
   *
   * @param snackName   The name of the snack.
   * @param dishes      The dishes included in the snack.
   * @param portionSize The portion size of the snack.
   */
  public Snack(String snackName, String dishes, String portionSize) {
    this.snackName = snackName;
    this.dishes = dishes;
    this.portionSize = portionSize;
  }

  /**
   * Gets the name of the snack.
   *
   * @return The name of the snack.
   */
  public String getSnackName() {
    return snackName;
  }

  /**
   * Sets the name of the snack.
   *
   * @param snackName The name of the snack to set.
   */
  public void setSnackName(String snackName) {
    this.snackName = snackName;
  }

  /**
   * Gets the dishes included in the snack.
   *
   * @return The dishes included in the snack.
   */
  public String getDishes() {
    return dishes;
  }

  /**
   * Sets the dishes included in the snack.
   *
   * @param dishes The dishes to set for the snack.
   */
  public void setDishes(String dishes) {
    this.dishes = dishes;
  }

  /**
   * Gets the portion size of the snack.
   *
   * @return The portion size of the snack.
   */
  public String getPortionSize() {
    return portionSize;
  }

  /**
   * Sets the portion size of the snack.
   *
   * @param portionSize The portion size to set for the snack.
   */
  public void setPortionSize(String portionSize) {
    this.portionSize = portionSize;
  }
}

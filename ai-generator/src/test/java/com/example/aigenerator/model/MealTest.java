package com.example.aigenerator.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class tests the methods in the Meal class.
 */
class MealTest {

  Meal meal1;
  Meal meal2;

  @BeforeEach
  void setUp() {
    meal1 = new Meal();
    meal2 = new Meal("Breakfast", "Oatmeal with berries", "1 cup oatmeal, 1 cup mixed berries");
  }

  /**
   * Tests getMealName method
   */
  @Test
  void testGetMealName() {
    assertNull(meal1.getMealName());
    assertEquals("Breakfast", meal2.getMealName());
  }

  /**
   * Tests setMealName method
   */
  @Test
  void testSetMealName() {
    meal1.setMealName("Lunch");
    assertEquals("Lunch", meal1.getMealName());
    meal2.setMealName("Dinner");
    assertEquals("Dinner", meal2.getMealName());
  }

  /**
   * Tests getDishes method
   */
  @Test
  void testGetDishes() {
    assertNull(meal1.getDishes());
    assertEquals("Oatmeal with berries", meal2.getDishes());
  }

  /**
   * Tests setDishes method
   */
  @Test
  void testSetDishes() {
    meal1.setDishes("French Toast");
    assertEquals("French Toast", meal1.getDishes());
    meal2.setDishes("Veggie Omelette");
    assertEquals("Veggie Omelette", meal2.getDishes());
  }

  /**
   * Tests getPortionSize method
   */
  @Test
  void testGetPortionSize() {
    assertNull(meal1.getPortionSize());
    assertEquals("1 cup oatmeal, 1 cup mixed berries", meal2.getPortionSize());
  }

  /**
   * Tests setPortionSize method
   */
  @Test
  void testSetPortionSize() {
    meal1.setPortionSize("2 slices of toasts");
    assertEquals("2 slices of toasts", meal1.getPortionSize());
    meal2.setPortionSize("1 cup instant oatmeal");
    assertEquals("1 cup instant oatmeal", meal2.getPortionSize());
  }
}
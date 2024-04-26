package com.example.aigenerator.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class tests the methods of the DietPreferences class.
 */
class DietPreferencesTest {

  DietPreferences test1;
  DietPreferences test2;
  DietPreferences test3;


  @BeforeEach
  void setUp() {
    test1 = new DietPreferences("DASH Diet", "Greek", 1800, "2", "1", "None", "Spinach, Walnuts");
    test2 = new DietPreferences("Vegan Diet", "Indian", 2500, "1", "6", "Eggs, Gluten, Soy",
        "None");
    test3 = new DietPreferences();
  }

  /**
   * Tests getDietType method
   */
  @Test
  void testGetDietType() {
    assertEquals("DASH Diet", test1.getDietType());
    assertEquals("Vegan Diet", test2.getDietType());
    assertNull(test3.getDietType());
  }

  /**
   * Tests setDietType method
   */
  @Test
  void testSetDietType() {
    test1.setDietType("Keto Diet");
    assertEquals("Keto Diet", test1.getDietType());
    test2.setDietType("Vegetarian Diet");
    assertEquals("Vegetarian Diet", test2.getDietType());
    test3.setDietType("Regular Diet");
    assertEquals("Regular Diet", test3.getDietType());
  }

  /**
   * Tests getCuisine method
   */
  @Test
  void testGetCuisine() {
    assertEquals("Greek", test1.getCuisine());
    assertEquals("Indian", test2.getCuisine());
    assertNull(test3.getCuisine());
  }

  /**
   * Tests setCuisine method
   */
  @Test
  void testSetCuisine() {
    test1.setCuisine("Chinese");
    assertEquals("Chinese", test1.getCuisine());
    test2.setCuisine("Thai");
    assertEquals("Thai", test2.getCuisine());
    test3.setCuisine("Korean");
    assertEquals("Korean", test3.getCuisine());
  }

  /**
   * Tests getCalories method
   */
  @Test
  void testGetCalories() {
    assertEquals(1800, test1.getCalories());
    assertEquals(2500, test2.getCalories());
  }

  /**
   * Tests setCalories method
   */
  @Test
  void testSetCalories() {
    test1.setCalories(1500);
    assertEquals(1500, test1.getCalories());
    test2.setCalories(3000);
    assertEquals(3000, test2.getCalories());
    test3.setCalories(1200);
    assertEquals(1200, test3.getCalories());
  }

  /**
   * Tests getMealTimeString method
   */
  @Test
  void testGetMealTimeString() {
    assertEquals("2", test1.getMealTimeString());
    assertEquals("1", test2.getMealTimeString());
    assertNull(test3.getMealTimeString());
  }

  /**
   * Tests setMealTimeString method
   */
  @Test
  void testSetMealTimeString() {
    test1.setMealTimeString("0");
    assertEquals("0", test1.getMealTimeString());
    test2.setMealTimeString("5");
    assertEquals("5", test2.getMealTimeString());
    test3.setMealTimeString("4");
    assertEquals("4", test3.getMealTimeString());
  }

  /**
   * Tests getSnackTimeString method
   */
  @Test
  void testGetSnackTimeString() {
    assertEquals("1", test1.getSnackTimeString());
    assertEquals("6", test2.getSnackTimeString());
    assertNull(test3.getSnackTimeString());
  }

  /**
   * Tests setSnackTimeString method
   */
  @Test
  void testSetSnackTimeString() {
    test1.setSnackTimeString("6");
    assertEquals("6", test1.getSnackTimeString());
    test2.setSnackTimeString("2");
    assertEquals("2", test2.getSnackTimeString());
    test3.setSnackTimeString("0");
    assertEquals("0", test3.getSnackTimeString());
  }

  /**
   * Tests getAllergySelectedItems method
   */
  @Test
  void testGetAllergySelectedItems() {
    assertEquals("None", test1.getAllergySelectedItems());
    assertEquals("Eggs, Gluten, Soy", test2.getAllergySelectedItems());
    assertNull(test3.getAllergySelectedItems());
  }

  /**
   * Tests setAllergySelectedItems method
   */
  @Test
  void testSetAllergySelectedItems() {
    test1.setAllergySelectedItems("Mango, Nuts");
    assertEquals("Mango, Nuts", test1.getAllergySelectedItems());
    test2.setAllergySelectedItems("None");
    assertEquals("None", test2.getAllergySelectedItems());
    test3.setAllergySelectedItems("Gluten, Shellfish");
    assertEquals("Gluten, Shellfish", test3.getAllergySelectedItems());
  }

  /**
   * Tests getDislikeSelectedItems method
   */
  @Test
  void testGetDislikeSelectedItems() {
    assertEquals("Spinach, Walnuts", test1.getDislikeSelectedItems());
    assertEquals("None", test2.getDislikeSelectedItems());
    assertNull(test3.getDislikeSelectedItems());
  }

  /**
   * Tests setDislikeSelectedItems method
   */
  @Test
  void testSetDislikeSelectedItems() {
    test1.setDislikeSelectedItems("Avocado, Broccoli, Crab, Fish");
    assertEquals("Avocado, Broccoli, Crab, Fish", test1.getDislikeSelectedItems());
    test2.setDislikeSelectedItems("Eggs, Raw Fish, Zucchini");
    assertEquals("Eggs, Raw Fish, Zucchini", test2.getDislikeSelectedItems());
    test3.setDislikeSelectedItems("Apple, Banana, Shrimp");
    assertEquals("Apple, Banana, Shrimp", test3.getDislikeSelectedItems());
  }
}
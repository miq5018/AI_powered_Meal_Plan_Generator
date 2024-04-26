package com.example.aigenerator.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class tests the methods of NutritionInfo class.
 */
class NutritionInfoTest {

  NutritionInfo test1;
  NutritionInfo test2;

  @BeforeEach
  void setUp() {
    test1 = new NutritionInfo();
    test2 = new NutritionInfo("2000 kcal", "70 g", "30 g", "150 g", "75 g");
  }

  /**
   * Tests getCalories method
   */
  @Test
  void testGetCalories() {
    assertNull(test1.getCalories());
    assertEquals("2000 kcal", test2.getCalories());
  }

  /**
   * Tests setCalories method
   */
  @Test
  void testSetCalories() {
    test1.setCalories("2100 kcal");
    assertEquals("2100 kcal", test1.getCalories());
    test2.setCalories("2200 kcal");
    assertEquals("2200 kcal", test2.getCalories());
  }

  /**
   * Tests getProtein method
   */
  @Test
  void testGetProtein() {
    assertNull(test1.getProtein());
    assertEquals("70 g", test2.getProtein());
  }

  /**
   * Tests setProtein method
   */
  @Test
  void testSetProtein() {
    test1.setProtein("80 g");
    assertEquals("80 g", test1.getProtein());
    test2.setProtein("90 g");
    assertEquals("90 g", test2.getProtein());
  }

  /**
   * Tests getFiber method
   */
  @Test
  void testGetFiber() {
    assertNull(test1.getFiber());
    assertEquals("30 g", test2.getFiber());
  }

  /**
   * Tests setFiber method
   */
  @Test
  void testSetFiber() {
    test1.setFiber("35 g");
    assertEquals("35 g", test1.getFiber());
    test2.setFiber("40 g");
    assertEquals("40 g", test2.getFiber());
  }

  /**
   * Tests getCarbs method
   */
  @Test
  void testGetCarbs() {
    assertNull(test1.getCarbs());
    assertEquals("150 g", test2.getCarbs());
  }

  /**
   * Tests setCarbs method
   */
  @Test
  void testSetCarbs() {
    test1.setCarbs("120 g");
    assertEquals("120 g", test1.getCarbs());
    test2.setCarbs("180 g");
    assertEquals("180 g", test2.getCarbs());
  }

  /**
   * Tests getFat method
   */
  @Test
  void testGetFat() {
    assertNull(test1.getFat());
    assertEquals("75 g", test2.getFat());
  }

  /**
   * Tests setFat method
   */
  @Test
  void testSetFat() {
    test1.setFat("90 g");
    assertEquals("90 g", test1.getFat());
    test2.setFat("80 g");
    assertEquals("80 g", test2.getFat());
  }
}
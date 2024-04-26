package com.example.aigenerator.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class tests the methods of Snack class.
 */
class SnackTest {

  Snack snack1;
  Snack snack2;

  @BeforeEach
  void setUp() {
    snack1 = new Snack();
    snack2 = new Snack("Morning Snack", "Mixed Nuts", "1 cup mixed nuts");
  }

  /**
   * Tests getSnackName method
   */
  @Test
  void testGetSnackName() {
    assertNull(snack1.getSnackName());
    assertEquals("Morning Snack", snack2.getSnackName());
  }

  /**
   * Tests setSnackName method
   */
  @Test
  void testSetSnackName() {
    snack1.setSnackName("Night Snack");
    assertEquals("Night Snack", snack1.getSnackName());
    snack2.setSnackName("Late Night Snack");
    assertEquals("Late Night Snack", snack2.getSnackName());
  }

  /**
   * Tests getDishes method
   */
  @Test
  void testGetDishes() {
    assertNull(snack1.getDishes());
    assertEquals("Mixed Nuts", snack2.getDishes());
  }

  /**
   * Tests setDishes method
   */
  @Test
  void testSetDishes() {
    snack1.setDishes("French Toast");
    assertEquals("French Toast", snack1.getDishes());
    snack2.setDishes("Yogurt");
    assertEquals("Yogurt", snack2.getDishes());
  }

  /**
   * Tests getPortionSize method
   */
  @Test
  void testGetPortionSize() {
    assertNull(snack1.getPortionSize());
    assertEquals("1 cup mixed nuts", snack2.getPortionSize());
  }

  /**
   * Tests setPortionSize method
   */
  @Test
  void testSetPortionSize() {
    snack1.setPortionSize("2 slices of toasts");
    assertEquals("2 slices of toasts", snack1.getPortionSize());
    snack2.setPortionSize("8 oz yogurt");
    assertEquals("8 oz yogurt", snack2.getPortionSize());
  }
}

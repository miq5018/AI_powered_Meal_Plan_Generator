package com.example.aigenerator.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MealPlanTest {
  MealPlan test1;
  MealPlan test2;

  Meal meal1;
  Meal meal2;
  Meal meal3;
  Snack snack1;
  Snack snack2;
  Snack snack3;
  NutritionInfo cal1;
  NutritionInfo cal2;
  NutritionInfo cal3;
  List<Meal> mealList1;
  List<Meal> mealList2;
  List<Snack> snackList1;
  List<Snack> snackList2;

  @BeforeEach
  void setUp() {
    test1 = new MealPlan();
    meal1 = new Meal("Breakfast", "Veggie Omelette", "2 eggs, 1 cup veggies");
    meal2 = new Meal("Lunch", "Grilled Chicken with Zucchini", "4 oz grilled chicken, 1 cup zucchini");
    meal3 = new Meal("Dinner", "Fish and Chips", "1 cup fish, 1 cup chips");
    snack1 = new Snack("Morning Snack", "Greek Yogurt", "1 cup yogurt");
    snack2 = new Snack("Afternoon Snack", "Banana", "1 medium banana");
    snack3 = new Snack("Night Snack", "Mixed Nuts", "1 cup mixed nuts");
    cal1 = new NutritionInfo("2000 kcal", "70 g", "30 g", "150 g", "75 g");
    cal2 = new NutritionInfo("1800 kcal", "60 g", "20 g", "130 g", "60 g");
    cal3 = new NutritionInfo("1500 kcal", "50 g", "25 g", "120 g", "55 g");
    mealList1 = new ArrayList<>();
    mealList1.add(meal1);
    mealList1.add(meal2);
    mealList2 = new ArrayList<>();
    mealList2.add(meal1);
    mealList2.add(meal2);
    mealList2.add(meal3);
    snackList1 = new ArrayList<>();
    snackList1.add(snack1);
    snackList1.add(snack2);
    snackList2 = new ArrayList<>();
    snackList2.add(snack1);
    snackList2.add(snack2);
    snackList2.add(snack3);
    test2 = new MealPlan(mealList1, snackList1, cal1);
  }

  /**
   * Tests getMeals method
   */
  @Test
  void testGetMeals() {
    assertNull(test1.getMeals());
    assertEquals(2, test2.getMeals().size());
    assertEquals("Breakfast", test2.getMeals().get(0).getMealName());
  }

  /**
   * Tests setMeals method
   */
  @Test
  void testSetMeals() {
    test1.setMeals(mealList1);
    assertEquals(2, test1.getMeals().size());
    assertEquals("Lunch", test1.getMeals().get(1).getMealName());
    test2.setMeals(mealList2);
    assertEquals(3, test2.getMeals().size());
    assertEquals("Dinner", test2.getMeals().get(2).getMealName());
  }

  /**
   * Tests getSnacks method
   */
  @Test
  void testGetSnacks() {
    assertNull(test1.getSnacks());
    assertEquals(2, test2.getSnacks().size());
    assertEquals("Afternoon Snack", test2.getSnacks().get(1).getSnackName());
  }

  /**
   * Tests setSnacks method
   */
  @Test
  void testSetSnacks() {
    test1.setSnacks(snackList1);
    assertEquals(2, test1.getSnacks().size());
    assertEquals("Greek Yogurt", test1.getSnacks().get(0).getDishes());
    test2.setSnacks(snackList2);
    assertEquals(3, test2.getSnacks().size());
    assertEquals("Night Snack", test2.getSnacks().get(2).getSnackName());
  }

  /**
   * Tests getDailyTotal method
   */
  @Test
  void testGetDailyTotal() {
    assertNull(test1.getDailyTotal());
    assertEquals("2000 kcal", test2.getDailyTotal().getCalories());
    assertEquals("70 g", test2.getDailyTotal().getProtein());
    assertEquals("30 g", test2.getDailyTotal().getFiber());
    assertEquals("150 g", test2.getDailyTotal().getCarbs());
    assertEquals("75 g", test2.getDailyTotal().getFat());
  }

  /**
   * Tests setDailyTotal method
   */
  @Test
  void testSetDailyTotal() {
    test1.setDailyTotal(cal2);
    assertEquals("1800 kcal", test1.getDailyTotal().getCalories());
    assertEquals("60 g", test1.getDailyTotal().getProtein());
    assertEquals("20 g", test1.getDailyTotal().getFiber());
    assertEquals("130 g", test1.getDailyTotal().getCarbs());
    assertEquals("60 g", test1.getDailyTotal().getFat());
    test2.setDailyTotal(cal3);
    assertEquals("1500 kcal", test2.getDailyTotal().getCalories());
    assertEquals("50 g", test2.getDailyTotal().getProtein());
    assertEquals("25 g", test2.getDailyTotal().getFiber());
    assertEquals("120 g", test2.getDailyTotal().getCarbs());
    assertEquals("55 g", test2.getDailyTotal().getFat());
  }
}
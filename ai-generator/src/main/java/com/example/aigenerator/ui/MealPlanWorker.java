package com.example.aigenerator.ui;

import javax.swing.SwingWorker;

import com.example.aigenerator.model.DietPreferences;
import com.example.aigenerator.model.MealPlan;
import com.example.aigenerator.services.MealPlanService;

/**
 * This class responsible for generating a meal plan asynchronously.
 */
public class MealPlanWorker extends SwingWorker<MealPlan, Void> {

  private DietPreferences userPreferences;
  private BuildUI parentFrame;

  /**
   * Constructs a MealPlanWorker with the specified user preferences and parent frame.
   *
   * @param userPreferences The user's diet preferences.
   * @param parentFrame     The parent frame where the meal plan will be displayed.
   */
  public MealPlanWorker(DietPreferences userPreferences, BuildUI parentFrame) {
    this.userPreferences = userPreferences;
    this.parentFrame = parentFrame;
  }

  /**
   * Background task to generate a meal plan.
   *
   * @return The generated meal plan.
   * @throws Exception If an error occurs during meal plan generation.
   */
  @Override
  protected MealPlan doInBackground() throws Exception {
    return MealPlanService.generateMealPlan(userPreferences);
  }

  /**
   * Executed on the Event Dispatch Thread after the doInBackground method is finished.
   */
  @Override
  protected void done() {
    try {
      MealPlan jsonResponse = get();
      if (jsonResponse != null) {
        parentFrame.showLoading(false);
        ;
        parentFrame.showMealPlanPanel(jsonResponse, userPreferences);
      } else {
        // Handle case where meal plan generation failed
        System.out.println("Meal plan generation failed.");
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
package com.example.aigenerator.ui;

import javax.swing.SwingWorker;

import com.example.aigenerator.model.DietPreferences;
import com.example.aigenerator.model.MealPlan;
import com.example.aigenerator.services.MealPlanService;

public class MealPlanWorker extends SwingWorker<MealPlan, Void> {
    private DietPreferences userPreferences;
    private BuildUI parentFrame;

    public MealPlanWorker(DietPreferences userPreferences, BuildUI parentFrame) {
        this.userPreferences = userPreferences;
        this.parentFrame = parentFrame;
    }

    @Override
    protected MealPlan doInBackground() throws Exception {
        return MealPlanService.generateMealPlan(userPreferences);
    }

    @Override
    protected void done() {
        try {
            MealPlan jsonResponse = get();
            if (jsonResponse != null) {
                parentFrame.showLoading(false);;
                parentFrame.showMealPlanPanel(jsonResponse, userPreferences);
            } else {
                // Handle case where meal plan generation failed
                System.out.println("Meal plan generation failed.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            // Handle exception
        } 
    }
}
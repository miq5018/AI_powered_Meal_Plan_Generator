package com.example.aigenerator.ui;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.example.aigenerator.model.MealPlan;

public class MealPlanPanel extends JPanel {
    MealPlan responseJson;

    public MealPlanPanel(BuildUI parentFrame, MealPlan responseJson){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //Set header
        JLabel mealPlanHeaderLabel = new JLabel("Here is Your One-Day Meal Plan");
        mealPlanHeaderLabel.setFont(new Font("SANS_SERIF", Font.BOLD, 30));
        mealPlanHeaderLabel.setAlignmentX(CENTER_ALIGNMENT);

        //Meal Labels
        JTextArea mealText = new JTextArea();
        mealText.setEditable(false);

        StringBuilder meals = new StringBuilder(); 
        for(int i = 0; i < responseJson.getMealPlan().size(); i++){
            meals.append("Meal/Snack: ");
            meals.append(responseJson.getMealPlan().get(i).getMealName());
            meals.append("\n");
            meals.append("Dishes: ");
            meals.append(responseJson.getMealPlan().get(i).getDishes());
            meals.append("\n");
            meals.append("Portion Size: ");
            meals.append(responseJson.getMealPlan().get(i).getPortionSize());
            meals.append("\n");
        }
        
        mealText.setText(meals.toString());
        JScrollPane scrollPaneMeal = new JScrollPane(mealText);


        JTextArea nutritionText = new JTextArea();
        nutritionText.setEditable(false);

        StringBuilder nutritionInfo = new StringBuilder();
        nutritionInfo.append("Daily Total Nutrition Info: \n");
        nutritionInfo.append("Calories: ");
        nutritionInfo.append(responseJson.getDailyTotal().getCalories());
        nutritionInfo.append("\n");
        nutritionInfo.append("Proteins: ");
        nutritionInfo.append(responseJson.getDailyTotal().getProtein());
        nutritionInfo.append("\n");
        nutritionInfo.append("Fats: ");
        nutritionInfo.append(responseJson.getDailyTotal().getFat());
        nutritionInfo.append("\n");
        nutritionInfo.append("Carbohydrates: ");
        nutritionInfo.append(responseJson.getDailyTotal().getCarbs());
        nutritionInfo.append("\n");
        nutritionInfo.append("Fibers: ");
        nutritionInfo.append(responseJson.getDailyTotal().getFiber());
        nutritionInfo.append("\n");

        nutritionText.setText(nutritionInfo.toString());
        JScrollPane scrollPaneNutrition = new JScrollPane(nutritionText);

        add(mealPlanHeaderLabel);
        add(scrollPaneMeal);
        add(scrollPaneNutrition);
    }
}

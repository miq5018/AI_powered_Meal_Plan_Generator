package com.example.aigenerator.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
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
        add(mealPlanHeaderLabel);


        //Meal Labels
        for(int i = 0; i < responseJson.getMealPlan().size(); i++){
            JLabel mealLabel = new JLabel();
            StringBuilder meals = new StringBuilder(); 
            meals.append("Meal/Snack: ");
            meals.append(responseJson.getMealPlan().get(i).getMealName());
            meals.append("\n");
            meals.append("Dishes: ");
            meals.append(responseJson.getMealPlan().get(i).getDishes());
            meals.append("\n");
            meals.append("Portion Size: ");
            meals.append(responseJson.getMealPlan().get(i).getPortionSize());
            meals.append("\n");
            mealLabel.setText(meals.toString());
            add(mealLabel);
        }
        
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

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(228, 234, 245));
        JButton startOverButton = new JButton();
        startOverButton.setText("Startover");
        startOverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                parentFrame.showLaunchPanel();
            }
        });


        buttonPanel.add(startOverButton);

        add(scrollPaneNutrition);
        add(buttonPanel);
    }
}

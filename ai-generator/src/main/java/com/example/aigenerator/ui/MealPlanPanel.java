package com.example.aigenerator.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import com.example.aigenerator.model.DietPreferences;
import com.example.aigenerator.model.MealPlan;
import com.example.aigenerator.services.MealPlanService;


public class MealPlanPanel extends JPanel {
    MealPlan responseJson;

    public MealPlanPanel(BuildUI parentFrame, MealPlan responseJson, DietPreferences userPreferences){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //Set header
        JLabel mealPlanHeaderLabel = new JLabel("Here is Your One-Day Meal Plan");
        mealPlanHeaderLabel.setFont(new Font("SANS_SERIF", Font.BOLD, 35));
        mealPlanHeaderLabel.setAlignmentX(CENTER_ALIGNMENT);
        add(Box.createRigidArea(new Dimension(0, 15)));  
        add(mealPlanHeaderLabel);
        add(Box.createRigidArea(new Dimension(0, 15)));  

        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));
        containerPanel.setBackground(new Color(252,250,248));
        if(responseJson.getMeals() != null){
            if(responseJson.getMeals().size() != 0){
                JPanel mealHeaderPanel = new JPanel();
                mealHeaderPanel.setBackground(new Color(200,219,249));
                mealHeaderPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
                mealHeaderPanel.setBorder(BorderFactory.createEmptyBorder(5, 35, 5, 20));
                JLabel mealHeaderLabel = new JLabel("Meals: ");
                mealHeaderLabel.setFont(new Font("SANS_SERIF", Font.BOLD, 25));
                mealHeaderPanel.add(mealHeaderLabel);
                containerPanel.add(mealHeaderPanel);
            
                //Meal Labels
                for(int j = 0; j < responseJson.getMeals().size(); j++){
                    JPanel mealPanel = new JPanel();
                    mealPanel.setBackground(new Color(252,250,248));
                    mealPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
                    mealPanel.setBorder(BorderFactory.createEmptyBorder(5, 50, 5, 20));
                    JLabel mealResponseLabel = new JLabel();
                    mealResponseLabel.setText(responseJson.getMeals().get(j).getMealName());
                    mealResponseLabel.setFont(new Font("SANS_SERIF", Font.BOLD, 22));
                    mealPanel.add(mealResponseLabel);

                    JPanel dishPanel = new JPanel();
                    dishPanel.setBackground(new Color(252,250,248));
                    dishPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
                    dishPanel.setBorder(BorderFactory.createEmptyBorder(5, 50, 5, 20));
                    JLabel dishResponseLabel = new JLabel();
                    dishResponseLabel.setText(responseJson.getMeals().get(j).getDishes());
                    dishResponseLabel.setFont(new Font("ARIAL", Font.PLAIN, 20));
                    dishPanel.add(dishResponseLabel);

                    JPanel portionPanel = new JPanel();
                    portionPanel.setBackground(new Color(252,250,248));
                    portionPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
                    portionPanel.setBorder(BorderFactory.createEmptyBorder(5, 50, 5, 20));
                    JLabel portionLabel = new JLabel();
                    portionLabel.setText("Ingredients:");
                    portionLabel.setFont(new Font("ARIAL", Font.ITALIC, 17));
                    JLabel portionResponseLabel = new JLabel();
                    portionResponseLabel.setText(responseJson.getMeals().get(j).getPortionSize());
                    portionResponseLabel.setFont(new Font("ARIAL", Font.ITALIC, 17));
                    portionPanel.add(portionLabel);
                    portionPanel.add(portionResponseLabel);

                    containerPanel.add(mealPanel);
                    containerPanel.add(dishPanel);
                    containerPanel.add(portionPanel);
                    if(j < responseJson.getMeals().size() - 1){
                        containerPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
                    }
                    if(j == responseJson.getMeals().size() - 1){
                        containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
                    }
                }
            }
        }

        if(responseJson.getSnacks() != null){
            if(responseJson.getSnacks().size() != 0){
                JPanel snackHeaderPanel = new JPanel();
                snackHeaderPanel.setBackground(new Color(200,219,249));
                snackHeaderPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
                snackHeaderPanel.setBorder(BorderFactory.createEmptyBorder(5, 35, 5, 20));
                JLabel snackHeaderLabel = new JLabel("Snacks: ");
                snackHeaderLabel.setFont(new Font("SANS_SERIF", Font.BOLD, 25));
                snackHeaderPanel.add(snackHeaderLabel);
                containerPanel.add(snackHeaderPanel);
        
                //Snack Labels
                for(int i = 0; i < responseJson.getSnacks().size(); i++){
                    JPanel mealPanel = new JPanel();
                    mealPanel.setBackground(new Color(252,250,248));
                    mealPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
                    mealPanel.setBorder(BorderFactory.createEmptyBorder(5, 50, 5, 20));
                    JLabel mealResponseLabel = new JLabel();
                    mealResponseLabel.setText(responseJson.getSnacks().get(i).getSnackName());
                    mealResponseLabel.setFont(new Font("SANS_SERIF", Font.BOLD, 22));
                    mealPanel.add(mealResponseLabel);

                    JPanel dishPanel = new JPanel();
                    dishPanel.setBackground(new Color(252,250,248));
                    dishPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
                    dishPanel.setBorder(BorderFactory.createEmptyBorder(5, 50, 5, 20));
                    JLabel dishResponseLabel = new JLabel();
                    dishResponseLabel.setText(responseJson.getSnacks().get(i).getDishes());
                    dishResponseLabel.setFont(new Font("ARIAL", Font.PLAIN, 20));
                    dishPanel.add(dishResponseLabel);

                    JPanel portionPanel = new JPanel();
                    portionPanel.setBackground(new Color(252,250,248));
                    portionPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
                    portionPanel.setBorder(BorderFactory.createEmptyBorder(5, 50, 5, 20));
                    JLabel portionLabel = new JLabel();
                    portionLabel.setText("Ingredients:");
                    portionLabel.setFont(new Font("ARIAL", Font.ITALIC, 17));
                    JLabel portionResponseLabel = new JLabel();
                    portionResponseLabel.setText(responseJson.getSnacks().get(i).getPortionSize());
                    portionResponseLabel.setFont(new Font("ARIAL", Font.ITALIC, 17));
                    portionPanel.add(portionLabel);
                    portionPanel.add(portionResponseLabel);

                    containerPanel.add(mealPanel);
                    containerPanel.add(dishPanel);
                    containerPanel.add(portionPanel);
                    if(i < responseJson.getSnacks().size() - 1){
                        containerPanel.add(new JSeparator(SwingConstants.HORIZONTAL));  
                    }    
                }
            }
        }
        
        JScrollPane scrollPane = new JScrollPane(containerPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(204,211,221), 2));
        add(scrollPane);
        add(Box.createRigidArea(new Dimension(0, 10)));  
        
        //Nutrition Header
        JPanel nutritionPanel = new JPanel();
        nutritionPanel.setBackground(new Color(228, 234, 245));
        nutritionPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        nutritionPanel.setBorder(BorderFactory.createEmptyBorder(5, 35, 5, 20));
        JLabel nutritionLabel = new JLabel();
        nutritionLabel.setText("Estimated Daily Total Nutrition Info: ");
        nutritionLabel.setFont(new Font("SANS_SERIF", Font.BOLD, 22));

        nutritionPanel.add(nutritionLabel);
        add(nutritionPanel);

        //Calories Panel
        JPanel panel1 = new JPanel();
        panel1.setBackground(new Color(228, 234, 245));
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel1.setBorder(BorderFactory.createEmptyBorder(5, 40, 5, 20));
        JLabel calorieLabel = new JLabel();
        calorieLabel.setText("Calories:");
        calorieLabel.setFont(new Font("SERIF", Font.BOLD, 17));
        JLabel calorieResponseLabel = new JLabel();
        calorieResponseLabel.setText(responseJson.getDailyTotal().getCalories());
        calorieResponseLabel.setFont(new Font("Arial", Font.PLAIN, 17));
        panel1.add(calorieLabel);
        panel1.add(calorieResponseLabel);
        panel1.add(new JLabel("    "));

        JLabel proteinLabel = new JLabel();
        proteinLabel.setText("Proteins:");
        proteinLabel.setFont(new Font("SERIF", Font.BOLD, 17));
        JLabel proteinResponseLabel = new JLabel();
        proteinResponseLabel.setText(responseJson.getDailyTotal().getProtein());
        proteinResponseLabel.setFont(new Font("Arial", Font.PLAIN, 17));
        panel1.add(proteinLabel);
        panel1.add(proteinResponseLabel);
        panel1.add(new JLabel("    "));

        JLabel fatLabel = new JLabel();
        fatLabel.setText("Fats:");
        fatLabel.setFont(new Font("SERIF", Font.BOLD, 17));
        JLabel fatResponseLabel = new JLabel();
        fatResponseLabel.setText(responseJson.getDailyTotal().getFat());
        fatResponseLabel.setFont(new Font("Arial", Font.PLAIN, 17));
        panel1.add(fatLabel);
        panel1.add(fatResponseLabel);
        panel1.add(new JLabel("    "));

        JLabel carbsLabel = new JLabel();
        carbsLabel.setText("Carbohydates:");
        carbsLabel.setFont(new Font("SERIF", Font.BOLD, 17));
        JLabel carbsResponseLabel = new JLabel();
        carbsResponseLabel.setText(responseJson.getDailyTotal().getCarbs());
        carbsResponseLabel.setFont(new Font("Arial", Font.PLAIN, 17));
        panel1.add(carbsLabel);
        panel1.add(carbsResponseLabel);
        panel1.add(new JLabel("    "));

        JLabel fiberLabel = new JLabel();
        fiberLabel.setText("Fibers:");
        fiberLabel.setFont(new Font("SERIF", Font.BOLD, 17));
        JLabel fibersResponseLabel = new JLabel();
        fibersResponseLabel.setText(responseJson.getDailyTotal().getFiber());
        fibersResponseLabel.setFont(new Font("ARIAL", Font.PLAIN, 17));
        panel1.add(fiberLabel);
        panel1.add(fibersResponseLabel);

        add(panel1);
        add(Box.createRigidArea(new Dimension(0, 10)));  

        //Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(228, 234, 245));
        JButton startOverButton = new JButton();
        startOverButton.setText("Startover");
        startOverButton.setFont(new Font("SERIF", Font.PLAIN, 22));
        startOverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                parentFrame.showLaunchPanel();
            }
        });


        JButton regenerateButton = new JButton();
        regenerateButton.setText("Regenerate");
        regenerateButton.setFont(new Font("SERIF", Font.PLAIN, 22));
        regenerateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                regenerateButton.setEnabled(false);
                parentFrame.showLoading(true);
                
                MealPlanWorker worker = new MealPlanWorker(userPreferences, parentFrame);
                worker.execute();

                //MealPlan jsonResponse = MealPlanService.generateMealPlan(userPreferences);
                //parentFrame.showMealPlanPanel(jsonResponse, userPreferences);
            }
        });

        buttonPanel.add(startOverButton);
        buttonPanel.add(new JLabel("                "));
        buttonPanel.add(regenerateButton);

        add(buttonPanel);
        add(Box.createRigidArea(new Dimension(0, 10)));
    }
}

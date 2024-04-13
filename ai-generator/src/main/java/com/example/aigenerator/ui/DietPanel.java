package com.example.aigenerator.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import com.example.aigenerator.model.MealPlan;
import com.example.aigenerator.services.MealPlanService;



public class DietPanel extends JPanel{
    public String dietType;
    public String cuisine;
    public int calories;
    public String mealTimeString;
    public String snackTimeString;

    
    public DietPanel(BuildUI parentFrame) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


        //Set header
        JLabel dietHeaderLabel = new JLabel("Diet Preferences");
        dietHeaderLabel.setFont(new Font("SANS_SERIF", Font.BOLD, 50));
        dietHeaderLabel.setAlignmentX(CENTER_ALIGNMENT);


        //Diet comboBox
        JPanel dietPanel = new JPanel();
        dietPanel.setBackground(new Color(228, 234, 245));
        JLabel dietLabel = new JLabel();
        dietLabel.setText("Diet: ");
        dietLabel.setFont(new Font("SERIF", Font.PLAIN, 25));

        String[] Diet = {" ", "Regular Diet", "Keto Diet", "Low Carb Diet", "Vegan Diet", "Vegetarian Diet", "DASH Diet", "Paleo Diet"};
        JComboBox<String> dietComboBox = new JComboBox<>(Diet);
        dietComboBox.setFont(new Font("COURIER", Font.PLAIN, 20));

        dietPanel.add(dietLabel);
        dietPanel.add(dietComboBox);

        //Cuisine comboBox
        JPanel cuisinePanel = new JPanel();
        cuisinePanel.setBackground(new Color(228, 234, 245));
        JLabel cuisineLabel = new JLabel();
        cuisineLabel.setText("Preferred Cuisine: ");
        cuisineLabel.setFont(new Font("SERIF", Font.PLAIN, 25));

        String[] Cuisines = {" ", "American", "Chinese", "Greek", "Indian", "Italian", "Japanese", "Korean", "Mexican", "Thai", "Vietnamese"};
        JComboBox<String> cuisineComboBox = new JComboBox<>(Cuisines);
        cuisineComboBox.setFont(new Font("COURIER", Font.PLAIN, 20));

        cuisinePanel.add(cuisineLabel);
        cuisinePanel.add(cuisineComboBox);


        //Calorie TextFieldx
        JPanel caloriePanel = new JPanel();
        caloriePanel.setBackground(new Color(228, 234, 245));

        JLabel calorieLabel = new JLabel();
        calorieLabel.setText("Daily Calorie Needs: ");
        calorieLabel.setFont(new Font("SERIF", Font.PLAIN, 25));

        JTextField calorieTextField = new JTextField();
        calorieTextField.setPreferredSize(new Dimension(250, 30));

        JLabel calorieUnitLabel = new JLabel();
        calorieLabel.setText("kcal/day");
        calorieLabel.setFont(new Font("SERIF", Font.PLAIN, 25));
        
        caloriePanel.add(calorieLabel);
        caloriePanel.add(calorieTextField);
        caloriePanel.add(calorieUnitLabel);
        

        //Meal Times Combobox
        JPanel mealTimePanel = new JPanel();
        mealTimePanel.setBackground(new Color(228, 234, 245));
        JLabel mealTimeLabel = new JLabel();
        mealTimeLabel.setText("Meals/Day: ");
        mealTimeLabel.setFont(new Font("SERIF", Font.PLAIN, 25));

        String[] mealTimes = {" ", "0", "1", "2", "3", "4", "5", "6"};
        JComboBox<String> mealTimeComboBox = new JComboBox<>(mealTimes);
        mealTimeComboBox.setFont(new Font("COURIER", Font.PLAIN, 20));

        mealTimePanel.add(mealTimeLabel);
        mealTimePanel.add(mealTimeComboBox);


        //Snack Times Combobox
        JPanel snackTimePanel = new JPanel();
        snackTimePanel.setBackground(new Color(228, 234, 245));
        JLabel snackTimeLabel = new JLabel();
        snackTimeLabel.setText("Snacks/Day: ");
        snackTimeLabel.setFont(new Font("SERIF", Font.PLAIN, 25));

        String[] snackTimes = {" ", "0", "1", "2", "3", "4", "5", "6"};
        JComboBox<String> snackTimeComboBox = new JComboBox<>(snackTimes);
        snackTimeComboBox.setFont(new Font("COURIER", Font.PLAIN, 20));

        snackTimePanel.add(snackTimeLabel);
        snackTimePanel.add(snackTimeComboBox);


        //Allergy multi-select list
        JPanel allergyPanel = new JPanel();
        allergyPanel.setBackground(new Color(228, 234, 245));

        JLabel allergyLable = new JLabel();
        allergyLable.setText("Food Allergy/Intolerence: ");
    
        String[] allergyFoods = {"Nuts", "Dairy", "Gluten", "Eggs", "Fish", "Shellfish", "Soy"};
        JList<String> allergyFoodList = new JList<>(allergyFoods);
        allergyFoodList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        JScrollPane allergyScrollPane = new JScrollPane(allergyFoodList);

        allergyPanel.add(allergyLable);
        allergyPanel.add(allergyScrollPane);
    
        //Dislike multi-select list
        JPanel dislikePanel = new JPanel();
        dislikePanel.setBackground(new Color(228, 234, 245));

        JLabel dislikeLable = new JLabel();
        dislikeLable.setText("Disliked Foods: ");

        String[] dislikeFoods = {"Nuts", "Dairy", "Eggs", "Fish", "Shellfish", "Soy", "Beef", "Lamb", "Pork", "Chicken", "Duck", "Raw Fish", "Carrots", "Broccoli", "Spinach", "Asparagus"};
        JList<String> dislikeFoodList = new JList<>(dislikeFoods);
        dislikeFoodList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        JScrollPane dislikeScrollPane = new JScrollPane(dislikeFoodList);

        allergyPanel.add(dislikeLable);
        allergyPanel.add(dislikeScrollPane);
    
        
        //Button Panel with back and generate buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(228, 234, 245));
        JButton backButton = new JButton();
        backButton.setText("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                parentFrame.showLaunchPanel();
            }
        });

        JButton generateButton = new JButton();
        generateButton.setText("Generate My Plan");
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                dietType = (String) dietComboBox.getSelectedItem();
                System.out.println(dietType);

                cuisine = (String) cuisineComboBox.getSelectedItem();
                System.out.println(cuisine);

                calories = Integer.parseInt(calorieTextField.getText());
                System.out.println(calories);

                mealTimeString = (String) mealTimeComboBox.getSelectedItem();
                System.out.println(mealTimeString);

                snackTimeString = (String) snackTimeComboBox.getSelectedItem();
                System.out.println(snackTimeString);

                StringBuilder allergySelectedItems = new StringBuilder(); 
                for(int i = 0; i < allergyFoodList.getSelectedValuesList().size(); i++){
                    String allergySelectedItem = allergyFoodList.getSelectedValuesList().get(i);
                    if(i == allergyFoodList.getSelectedValuesList().size() - 1){
                        allergySelectedItems.append(allergySelectedItem);
                    }
                    else{
                        allergySelectedItems.append(allergySelectedItem).append(", ");
                    }
                }
                System.out.println(allergySelectedItems.toString());

                StringBuilder dislikeSelectedItems = new StringBuilder(); 
                for(int i = 0; i < dislikeFoodList.getSelectedValuesList().size(); i++){
                    String dislikeSelectedItem = dislikeFoodList.getSelectedValuesList().get(i);
                    if(i == dislikeFoodList.getSelectedValuesList().size() - 1){
                        dislikeSelectedItems.append(dislikeSelectedItem);
                    }
                    else{
                        dislikeSelectedItems.append(dislikeSelectedItem).append(", ");
                    }
                }
                System.out.println(dislikeSelectedItems.toString());


                MealPlan jsonResponse = MealPlanService.generateMealPlan(dietType, cuisine, calories, mealTimeString, snackTimeString, allergySelectedItems.toString(), dislikeSelectedItems.toString());
                
                parentFrame.showMealPlanPanel(jsonResponse);
            }
        });

        buttonPanel.add(backButton);
        buttonPanel.add(generateButton);


        add(Box.createRigidArea(new Dimension(0, 25)));
        add(dietHeaderLabel);
        add(Box.createRigidArea(new Dimension(0, 30)));
        add(dietPanel);
        add(Box.createRigidArea(new Dimension(0, 30)));
        add(cuisinePanel);
        add(Box.createRigidArea(new Dimension(0, 30)));
        add(caloriePanel);
        add(Box.createRigidArea(new Dimension(0, 30)));
        add(mealTimePanel);
        add(Box.createRigidArea(new Dimension(0, 30)));
        add(snackTimePanel);
        add(Box.createRigidArea(new Dimension(0, 30)));
        add(allergyPanel);
        add(Box.createRigidArea(new Dimension(0, 30)));
        add(dislikePanel);
        add(Box.createRigidArea(new Dimension(0, 30)));
        add(buttonPanel);
    }

}



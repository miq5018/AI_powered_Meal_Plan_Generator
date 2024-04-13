package com.example.aigenerator.ui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.example.aigenerator.model.MealPlan;

public class BuildUI extends JFrame{
    private JPanel currentPanel;

    public BuildUI() {
        initializeUI();
    }

    private void initializeUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 900);
        setTitle("MeaiPlanner");
        setLayout(null);
        setVisible(true);

        showLaunchPanel();
    }

    void showLaunchPanel() {
        currentPanel = new LaunchPanel(this);
        currentPanel.setBackground(new Color(228, 234, 245));
        setContentPane(currentPanel);
        revalidate();
        repaint();
    }

    void showDietPanel() {
        currentPanel = new DietPanel(this);
        currentPanel.setBackground(new Color(228, 234, 245));
        setContentPane(currentPanel);
        revalidate();
        repaint();
    }

    void showMealPlanPanel(MealPlan responseJson) {
        currentPanel = new MealPlanPanel(this, responseJson);
        currentPanel.setBackground(new Color(228, 234, 245));
        setContentPane(currentPanel);
        revalidate();
        repaint();
    }
}


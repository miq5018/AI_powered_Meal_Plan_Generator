package com.example.aigenerator.ui;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.example.aigenerator.model.DietPreferences;
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

    public void showMealPlanPanel(MealPlan responseJson, DietPreferences userPreferences) {
        currentPanel = new MealPlanPanel(this, responseJson, userPreferences);
        currentPanel.setBackground(new Color(228, 234, 245));
        setContentPane(currentPanel);
        revalidate();
        repaint();
    }

    public void showLoading(boolean show) {
        JPanel loadingPanel = new JPanel(new GridBagLayout());
        loadingPanel.setOpaque(false); 
        ImageIcon loadingIcon = new ImageIcon("src/main/resources/loading.gif"); 
        JLabel loadingLabel = new JLabel(loadingIcon);
        loadingPanel.add(loadingLabel);

        setGlassPane(loadingPanel);
        loadingPanel.setVisible(show);
    }
}


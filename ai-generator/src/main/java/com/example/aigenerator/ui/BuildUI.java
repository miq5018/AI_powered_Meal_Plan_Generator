package com.example.aigenerator.ui;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.example.aigenerator.model.DietPreferences;
import com.example.aigenerator.model.MealPlan;

/**
 * This class represents the main user interface of the application.
 */
public class BuildUI extends JFrame{
    private JPanel currentPanel;

    /**
     * Constructs a new BuildUI instance.
     */
    public BuildUI() {
        initializeUI();
    }

    /**
     * Initializes the user interface by setting up the frame and displaying the launch panel.
     */
    private void initializeUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 900);
        setTitle("MeaiPlanner");
        setLayout(null);
        setVisible(true);

        showLaunchPanel();
    }

    /**
     * Displays the launch panel in the UI.
     */
    void showLaunchPanel() {
        currentPanel = new LaunchPanel(this);
        currentPanel.setBackground(new Color(228, 234, 245));
        setContentPane(currentPanel);
        revalidate();
        repaint();
    }

    /**
     * Displays the diet panel in the UI.
     */
    void showDietPanel() {
        currentPanel = new DietPanel(this);
        currentPanel.setBackground(new Color(228, 234, 245));
        setContentPane(currentPanel);
        revalidate();
        repaint();
    }

    /**
     * Displays the meal plan panel in the UI.
     * 
     * @param responseJson The generated meal plan.
     * @param userPreferences The user's diet preferences.
     */
    public void showMealPlanPanel(MealPlan responseJson, DietPreferences userPreferences) {
        currentPanel = new MealPlanPanel(this, responseJson, userPreferences);
        currentPanel.setBackground(new Color(228, 234, 245));
        setContentPane(currentPanel);
        revalidate();
        repaint();
    }

    /**
     * Displays or hides the loading gif.
     * 
     * @param show Boolean value indicating whether to show or hide the loading gif.
     */
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


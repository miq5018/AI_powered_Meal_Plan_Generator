package com.example.aigenerator.ui;
import javax.swing.*;

/**
 * Main class to start the UI for the AI Generator application.
 */
public class Main {
    /**
     * Main method to start the UI for the AI Generator application.
     * @param args Command line arguments.
     */
    public static void main(String[] args){
        SwingUtilities.invokeLater(BuildUI::new);
    }
}

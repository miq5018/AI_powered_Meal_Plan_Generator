package ui;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LaunchPanel extends JPanel {
    public LaunchPanel(BuildUI parentFrame) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        //Set header image
        ImageIcon header = new ImageIcon("src/main/resources/header.jpg");
        JLabel headerLabel = new JLabel();
        headerLabel.setIcon(header);
        headerLabel.setAlignmentX(CENTER_ALIGNMENT);

        //Set app name
        JLabel appNameLabel = new JLabel();
        appNameLabel.setText("MeaiPlanner");
        appNameLabel.setFont(new Font("SANS_SERIF", Font.BOLD, 70));
        appNameLabel.setAlignmentX(CENTER_ALIGNMENT);

        //Set app intro
        JLabel appIntroLabel = new JLabel();
        appIntroLabel.setText("An AI-Powered Customized Meal Plan Generator");
        appIntroLabel.setFont(new Font("SERIF", Font.PLAIN, 30));
        appIntroLabel.setAlignmentX(CENTER_ALIGNMENT);

        //Set the Start button
        JButton startButton = new JButton();
        startButton.setText("Start");
        startButton.setFont(new Font("SANS_SERIF", Font.PLAIN, 30));
        startButton.addActionListener(e -> parentFrame.showDietPanel());
        startButton.setSize(300, 300);
        startButton.setAlignmentX(CENTER_ALIGNMENT);

        //Set the quote label
        JLabel quoteLabel = new JLabel();
        quoteLabel.setText("\"Empower your plate, nourish your life.\"");
        quoteLabel.setFont(new Font("SERIF", Font.PLAIN, 25));
        quoteLabel.setAlignmentX(CENTER_ALIGNMENT);

        add(Box.createRigidArea(new Dimension(0, 25)));
        add(headerLabel);
        add(Box.createRigidArea(new Dimension(0, 40)));
        add(appNameLabel);
        add(Box.createRigidArea(new Dimension(0, 15)));
        add(appIntroLabel);
        add(Box.createRigidArea(new Dimension(0, 50)));
        add(startButton);
        add(Box.createRigidArea(new Dimension(0, 40)));
        add(quoteLabel);
    }
}

   
    




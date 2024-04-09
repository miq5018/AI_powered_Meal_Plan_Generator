package UI;

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
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DietPanel extends JPanel{
    public static String dietType;
    public int calorie;
    
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

        String[] Diet = {"Regular Diet", "Keto Diet", "Low Carb Diet", "Vegan Diet", "Vegetarian Diet", "DASH Diet", "Paleo Diet"};
        JComboBox dietComboBox = new JComboBox(Diet);
        dietComboBox.setFont(new Font("COURIER", Font.PLAIN, 20));

        dietPanel.add(dietLabel);
        dietPanel.add(dietComboBox);


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
                calorie = Integer.parseInt(calorieTextField.getText());
            }
        });

        buttonPanel.add(backButton);
        buttonPanel.add(generateButton);


        add(Box.createRigidArea(new Dimension(0, 25)));
        add(dietHeaderLabel);
        add(Box.createRigidArea(new Dimension(0, 30)));
        add(dietPanel);
        add(Box.createRigidArea(new Dimension(0, 30)));
        add(caloriePanel);
        add(buttonPanel);
    }
}



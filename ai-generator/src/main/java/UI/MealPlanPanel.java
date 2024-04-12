package ui;

import java.awt.Font;
import java.io.File;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MealPlanPanel extends JPanel {
    String responseJson;

    public MealPlanPanel(BuildUI parentFrame){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


        //Set header
        JLabel mealPlanHeaderLabel = new JLabel("Here is Your One-Day Meal Plan");
        mealPlanHeaderLabel.setFont(new Font("SANS_SERIF", Font.BOLD, 30));
        mealPlanHeaderLabel.setAlignmentX(CENTER_ALIGNMENT);

        //
        JTextArea jsonTextArea = new JTextArea();
        jsonTextArea.setEditable(false);

        try {
            File file = new File("src/main/resources/mealPlan.json");
            ObjectMapper objectMapper = new ObjectMapper();
            responseJson = objectMapper.readValue(file, String.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        jsonTextArea.setText(responseJson);
        JScrollPane scrollPane = new JScrollPane(jsonTextArea);

        add(mealPlanHeaderLabel);
        add(scrollPane);
    }
}

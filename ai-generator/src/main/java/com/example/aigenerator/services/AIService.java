package com.example.aigenerator.services;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AIService {

    @Autowired
    ChatClient chatClient;

    public String response(String dietType, String cuisine, int calories, String mealTimeString, String snackTimeString, String allergySelectedItems, String dislikeSelectedItems){
        String mealPlanTemplate = "";
        try {
            // Read the content of the JSON file into a byte array
            byte[] encodedBytes = Files.readAllBytes(Paths.get("src/main/resources/meal_plan_template.json"));

            // Convert the byte array to a string using UTF-8 encoding
            mealPlanTemplate = new String(encodedBytes, StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
        }

        String promptMessage = "Please generate a one-day healthy and balanced meal plan with portion sizes and meeting the following requirements:\n" + 
                                "Diet Type: " + dietType + "\n" +
                                "Cuisine: " + cuisine + "\n" +
                                "Calorie Needs: " + calories + " kcals/day\n" + 
                                mealTimeString + " meals/day\n" + 
                                snackTimeString + " snacks/day\n" + 
                                "Food Allergies/Intolerance: " + allergySelectedItems + ", please do not include these or related foods\n" +
                                "Disliked food: " + dislikeSelectedItems + ", please do not include these or related foods" + 
                                "Please respond in this JSON format:" + mealPlanTemplate;
        Prompt prompt = new Prompt(promptMessage);
        return this.chatClient.call(prompt).toString();
    }
    

    public String response2(String dietType, String cuisine, int calories, String mealTimeString, String snackTimeString, String allergySelectedItems, String dislikeSelectedItems){
        String mealPlanTemplate = "";
        try {
            // Read the content of the JSON file into a byte array
            byte[] encodedBytes = Files.readAllBytes(Paths.get("src/main/resources/meal_plan_template_2.json"));

            // Convert the byte array to a string using UTF-8 encoding
            mealPlanTemplate = new String(encodedBytes, StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
        }

        
        String promptMessage = "Please generate a one-day healthy and balanced meal plan with portion sizes and meeting the following requirements:\n" + 
                                "Diet Type: " + dietType + "\n" +
                                "Cuisine: " + cuisine + "\n" +
                                "Calorie Needs: " + calories + " kcals/day\n" + 
                                "Food Allergies/Intolerance: " + allergySelectedItems + ", please do not include these or related foods\n" +
                                "Disliked food: " + dislikeSelectedItems + ", please do not include these or related foods" + 
                                "Please respond following this JSON format:" + mealPlanTemplate + "\n" + 
                                "This JSON format template contains 6 meals and 6 snacks. Please adjust the template to generate the meal plan with" + 
                                mealTimeString + " meals and " + snackTimeString + " snacks while still meeting other requirements listed above.";
        
        Prompt prompt = new Prompt(promptMessage);
        return this.chatClient.call(prompt).toString();
    }
}

package com.example.aigenerator.services;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aigenerator.model.DietPreferences;

/**
 * Service class responsible for formatting the prompt message 
 * and getting the responses from GPT using the prompt for meal planning requests.
 */
@Service
public class AIService {

    @Autowired
    ChatClient chatClient;

    /**
     * Gets the response from GPT for meal planning based on provided parameters and prompt template.
     * 
     * @param dietType             The type of diet preferred by the user.
     * @param cuisine              The preferred cuisine for meal planning.
     * @param calories             The target daily calorie intake for the planned meals.
     * @param mealTimeString       The frequency of main meals (e.g., breakfast, lunch, dinner) in one day.
     * @param snackTimeString      The frequency of snacks in one day.
     * @param allergySelectedItems Items the user is allergic to or intolerent with and wants to avoid in meal planning.
     * @param dislikeSelectedItems Items the user dislikes and wants to avoid in meal planning.
     * @return                     An AI-generated response String for meal planning in the provided JSON format.
     */
    /*
    public String response(String dietType, String cuisine, int calories, String mealTimeString, String snackTimeString, String allergySelectedItems, String dislikeSelectedItems){
        //Get the desired JSON response format from the template file
        String mealPlanTemplate = "";
        try {
            //Read the content of the JSON file into a byte array
            byte[] encodedBytes = Files.readAllBytes(Paths.get("src/main/resources/meal_plan_template.json"));
            //Convert the byte array to a string using UTF-8 encoding
            mealPlanTemplate = new String(encodedBytes, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //Formulate the prompt message using provided parameters and JSON template
        String promptMessage = "Please generate a one-day healthy and balanced meal plan with portion sizes and meeting the following requirements:\n" + 
                                "Diet Type: " + dietType + "\n" +
                                "Cuisine: " + cuisine + "\n" +
                                "Calorie Needs: " + calories + " kcals/day\n" + 
                                "Food Allergies/Intolerance: " + allergySelectedItems + ", please do not include these or related foods\n" +
                                "Disliked food: " + dislikeSelectedItems + ", please do not include these or related foods" + 
                                "Please respond following this JSON format:" + mealPlanTemplate + "\n" + 
                                "This JSON format template contains 6 meals and 6 snacks. Please adjust the template to generate the meal plan with" + 
                                mealTimeString + " meals and " + snackTimeString + " snacks while still meeting other requirements listed above.";
        
        System.out.println(promptMessage);

        Prompt prompt = new Prompt(promptMessage);
        return this.chatClient.call(prompt).toString();
    }
    */

    
    public String response(DietPreferences userPreferences){
        //Get the desired JSON response format from the template file
        String mealPlanTemplate = "";
        try {
            //Read the content of the JSON file into a byte array
            byte[] encodedBytes = Files.readAllBytes(Paths.get("src/main/resources/meal_plan_template.json"));
            //Convert the byte array to a string using UTF-8 encoding
            mealPlanTemplate = new String(encodedBytes, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        String dietType = userPreferences.getDietType();
        String cuisine = userPreferences.getCuisine();
        int calories = userPreferences.getCalories();
        String mealTimeString = userPreferences.getMealTimeString();
        String snackTimeString = userPreferences.getSnackTimeString();
        String allergySelectedItems = userPreferences.getAllergySelectedItems();
        String dislikeSelectedItems = userPreferences.getDislikeSelectedItems();


        //Formulate the prompt message using provided parameters and JSON template
        String promptMessage = "Please generate a one-day healthy and balanced meal plan with portion sizes and meeting the following requirements:\n" + 
                                "Diet Type: " + dietType + "\n" +
                                "Cuisine: " + cuisine + "\n" +
                                "Calorie Needs: " + calories + " kcals/day\n" + 
                                "Food Allergies/Intolerance: " + allergySelectedItems + ", please do not include these or related foods\n" +
                                "Disliked food: " + dislikeSelectedItems + ", please do not include these or related foods" + 
                                "Please respond following this JSON format:" + mealPlanTemplate + "\n" + 
                                "This JSON format template contains 6 meals and 6 snacks. Please adjust the template to generate the meal plan with " + 
                                mealTimeString + " meals and " + snackTimeString + " snacks while still meeting other requirements listed above.";
        
        System.out.println(promptMessage);

        Prompt prompt = new Prompt(promptMessage);
        return this.chatClient.call(prompt).toString();
    }
    
}

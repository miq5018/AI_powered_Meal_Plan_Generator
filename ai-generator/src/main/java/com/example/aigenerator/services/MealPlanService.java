package com.example.aigenerator.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.aigenerator.model.DietPreferences;
import com.example.aigenerator.model.MealPlan;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Service class responsible for generating a meal plan based on user preferences by calling an API.
 */
public class MealPlanService {
    /**
     * Generates a meal plan based on the provided user preferences by calling an API.
     *
     * @param userPreferences The user's preferences for generating the meal plan.
     * @return The generated meal plan.
     */
    public static MealPlan generateMealPlan(DietPreferences userPreferences){
        String jsonContent;
        MealPlan responseJson;
    
        String apiUrl = "http://localhost:8080/api/v1/generate";

        try {
            //Encode the DietPreferences object into query parameters
            String queryParameters = "dietType=" + URLEncoder.encode(userPreferences.getDietType(), "UTF-8") +
                        "&cuisine=" + URLEncoder.encode(userPreferences.getCuisine(), "UTF-8") +
                        "&calories=" + userPreferences.getCalories() +
                        "&mealTimeString=" + URLEncoder.encode(userPreferences.getMealTimeString(), "UTF-8") +
                        "&snackTimeString=" + URLEncoder.encode(userPreferences.getSnackTimeString(), "UTF-8") +
                        "&allergySelectedItems=" + URLEncoder.encode(userPreferences.getAllergySelectedItems(), "UTF-8") +
                        "&dislikeSelectedItems=" + URLEncoder.encode(userPreferences.getDislikeSelectedItems(), "UTF-8");

            //Append the query parameters to the URL
            apiUrl += "?" + queryParameters;
            System.out.println(apiUrl);

            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //Handle the response
            System.out.println(response.toString());

            //Parse the response based on a certain format
            Pattern pattern = Pattern.compile("content='(.*?)'", Pattern.DOTALL);
            Matcher matcher = pattern.matcher(response.toString());

            //Check if pattern is found
            if (matcher.find()) {
                jsonContent = matcher.group(1);
            }
            else{
                return null;
            }
            ObjectMapper objectMapper = new ObjectMapper();
            responseJson = objectMapper.readValue(jsonContent, MealPlan.class);
    
            connection.disconnect();
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return responseJson;
    }
    
}

package com.example.aigenerator.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JDialog;

import com.example.aigenerator.model.DietPreferences;
import com.example.aigenerator.model.MealPlan;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class MealPlanService {

    public static MealPlan generateMealPlan(DietPreferences userPreferences){
    
        String encodedDietType;
        String encodedAllergySelectedItems;
        String encodedDislikeSelectedItems;
        String jsonContent;
        MealPlan responseJson;

        try {
            encodedDietType = URLEncoder.encode(userPreferences.getDietType(), "UTF-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
            return null;
        }
        try {
            encodedAllergySelectedItems = URLEncoder.encode(userPreferences.getAllergySelectedItems(), "UTF-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
            return null;
        }
        try {
            encodedDislikeSelectedItems = URLEncoder.encode(userPreferences.getDislikeSelectedItems(), "UTF-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
            return null;
        }
        
        
        String apiUrl = "http://localhost:8080/api/v1/generate?dietType=" + encodedDietType + "&cuisine=" + userPreferences.getCuisine() +
                                "&calories=" + userPreferences.getCalories() + "&mealTimeString=" + userPreferences.getMealTimeString() + 
                                "&snackTimeString=" + userPreferences.getSnackTimeString() + "&allergySelectedItems=" + encodedAllergySelectedItems + 
                                "&dislikeSelectedItems=" + encodedDislikeSelectedItems;
        System.out.println(apiUrl);
        
        try {
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

            // Handle the response
            System.out.println(response.toString());

            //Pattern pattern = Pattern.compile("\\{\\s*\"meal_plan\":\\s*\"(.*?)'\".*?\\}", Pattern.DOTALL);
            Pattern pattern = Pattern.compile("content='(.*?)'", Pattern.DOTALL);
            Matcher matcher = pattern.matcher(response.toString());

            // Check if pattern is found
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
        
                /*
        String mealPlanTest = "";
        try {
            // Read the content of the JSON file into a byte array
            byte[] encodedBytes = Files.readAllBytes(Paths.get("src/main/resources/meal_plan_test.json"));

            // Convert the byte array to a string using UTF-8 encoding
            mealPlanTest = new String(encodedBytes, StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            responseJson = objectMapper.readValue(mealPlanTest, MealPlan.class);
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        */
    

        return responseJson;
    }
    
}

package com.example.aigenerator.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.aigenerator.model.MealPlan;
import com.fasterxml.jackson.databind.ObjectMapper;


public class MealPlanService {

    public static MealPlan generateMealPlan(String dietType, String cuisine, int calories, String mealTimeString, String snackTimeString, String allergySelectedItems, String dislikeSelectedItems){
        String encodedDietType;
        String encodedAllergySelectedItems;
        String encodedDislikeSelectedItems;
        String jsonContent;
        MealPlan responseJson;

        try {
            encodedDietType = URLEncoder.encode(dietType, "UTF-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
            return null;
        }
        try {
            encodedAllergySelectedItems = URLEncoder.encode(allergySelectedItems, "UTF-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
            return null;
        }
        try {
            encodedDislikeSelectedItems = URLEncoder.encode(dislikeSelectedItems, "UTF-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
            return null;
        }
        
        String apiUrl = "http://localhost:8080/api/v1/generate?dietType=" + encodedDietType + "&cuisine=" + cuisine +
                                "&calories=" + calories + "&mealTimeString=" + mealTimeString + 
                                "&snackTimeString=" + snackTimeString + "&allergySelectedItems=" + encodedAllergySelectedItems + 
                                "&dislikeSelectedItems=" + encodedDislikeSelectedItems;
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
        return responseJson;
    }
    
}

package com.example.aigenerator.services;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AIService {

    @Autowired
    ChatClient chatClient;

    public String response(String dietType, int calories, String mealTimeString, String snackTimeString, String allergySelectedItems, String dislikeSelectedItems){
        String promptMessage = "Can you give me a one-day healthy and balanced meal plan with portion sizes and meeting the following requirements in JSON format?\n" + 
                                "Diet Type: " + dietType + "\n" +
                                "Calorie Needs: " + calories + " kcals/day\n" + 
                                mealTimeString + " meals/day\n" + 
                                snackTimeString + " snacks/day\n" + 
                                "Food Allergies/Intolerance: " + allergySelectedItems + ", please do not include these or related foods\n" +
                                "Disliked food: " + dislikeSelectedItems + ", please do not include these or related foods";
        Prompt prompt = new Prompt(promptMessage);
        return this.chatClient.call(prompt).toString();
    }
    
}

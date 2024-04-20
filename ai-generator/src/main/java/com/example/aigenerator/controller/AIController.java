package com.example.aigenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.aigenerator.model.DietPreferences;
import com.example.aigenerator.services.AIService;

/**
 * Controller class responsible for handling requests related to AI-generated responses for meal planning.
 */
@RestController
@RequestMapping("/api/v1")
public class AIController {
    
    @Autowired
    AIService aiService;

   
    /**
     * Retrieves an AI-generated response based on provided parameters for meal planning.
     * 
     * @param dietType               The type of diet preferred by the user.
     * @param cuisine                The preferred cuisine for meal planning.
     * @param calories               The target daily calorie intake for the planned meals.
     * @param mealTimeString         The frequency of the main meals (e.g., breakfast, lunch, dinner) in one day.
     * @param snackTimeString        The frequency of snacks in one day.
     * @param allergySelectedItems   Items the user is allergic to or intolerence with and wants to avoid in meal planning.
     * @param dislikeSelectedItems   Items the user dislikes and wants to avoid in meal planning.
     * @return                       The AI-generated response in String for meal planning based on the provided parameters.
     */
    /*
    @GetMapping("/generate")
    public String getResponse(@RequestParam String dietType, @RequestParam String cuisine, @RequestParam int calories, @RequestParam String mealTimeString, @RequestParam String snackTimeString, @RequestParam String allergySelectedItems, @RequestParam String dislikeSelectedItems){
        return aiService.response(dietType, cuisine, calories, mealTimeString, snackTimeString, allergySelectedItems, dislikeSelectedItems);
    }
    */
    
    @GetMapping("/generate")
    public String getResponse(@ModelAttribute DietPreferences userPreferences){
        return aiService.response(userPreferences);
    }
    

}
 
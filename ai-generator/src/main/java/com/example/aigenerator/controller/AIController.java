package com.example.aigenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.aigenerator.services.AIService;

@RestController
@RequestMapping("/api/v1")
public class AIController {
    
    @Autowired
    AIService aiService;

    @GetMapping("/generate")
    public String getResponse(@RequestParam String dietType, @RequestParam String cuisine, @RequestParam int calories, @RequestParam String mealTimeString, @RequestParam String snackTimeString, @RequestParam String allergySelectedItems, @RequestParam String dislikeSelectedItems){
        //if(Integer.parseInt(mealTimeString) > 3 || Integer.parseInt(snackTimeString) > 3){
            return aiService.response2(dietType, cuisine, calories, mealTimeString, snackTimeString, allergySelectedItems, dislikeSelectedItems);
        //}
        //else{
           // return aiService.response(dietType, cuisine, calories, mealTimeString, snackTimeString, allergySelectedItems, dislikeSelectedItems);
        //}
    }
    
}

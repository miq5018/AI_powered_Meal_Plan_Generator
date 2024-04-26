package com.example.aigenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aigenerator.model.DietPreferences;
import com.example.aigenerator.services.AIService;

/**
 * Controller class responsible for handling requests related to AI-generated responses for meal
 * planning.
 */
@RestController
@RequestMapping("/api/v1")
public class AIController {

  @Autowired
  AIService aiService;

  /**
   * Retrieves an AI-generated response based on provided parameters for meal planning.
   *
   * @param userPreferences The user's preferences for generating the meal plan.
   * @return AI-generated response in String
   */
  @GetMapping("/generate")
  public String getResponse(@ModelAttribute DietPreferences userPreferences) {
    return aiService.response(userPreferences);
  }
}
 
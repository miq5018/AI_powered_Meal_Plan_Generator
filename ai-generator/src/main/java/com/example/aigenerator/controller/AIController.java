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
    public String getResponse(@RequestParam(defaultValue = "Regular diet") String dietType, @RequestParam int calories){
        return aiService.response(dietType, calories);
    }
    
}

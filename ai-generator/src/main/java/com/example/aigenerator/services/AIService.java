package com.example.aigenerator.services;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AIService {

    @Autowired
    ChatClient chatClient;

    public String response(String dietType, int calories){
        String promptMessage = "Can you give me a one-day meal plan for " + dietType + " for " + calories + " kcals?";
        Prompt prompt = new Prompt(promptMessage);
        return this.chatClient.call(prompt).toString();
    }
    
}

package com.tonycalarese.ai_chatbot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ai.openai.OpenAiService;
import org.springframework.ai.openai.model.CompletionRequest;
import org.springframework.ai.openai.model.CompletionResponse;

@RequiredArgsConstructor
@Service
public class AIAgentService {
    private final OpenAiService openAiService;


    public String generateResponse(String prompt) {
        CompletionRequest request = CompletionRequest.builder()
                .model("text-davinci-003") // Specify the model
                .prompt(prompt)
                .maxTokens(150)
                .temperature(0.7)
                .build();

        CompletionResponse response = openAiService.createCompletion(request);
        return response.getChoices().get(0).getText().trim();
    }
}
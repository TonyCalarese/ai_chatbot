package com.tonycalarese.ai_chatbot.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.openai.*;

import java.util.Arrays;

@RequiredArgsConstructor
@Service
@Slf4j
public class AIAgentService {
    //private final OpenAiService openAiService;

    @Value("${spring.ai.openai.api-key}")
    private String apiKey;

//    public String generateResponse(String prompt) {
//        CompletionRequest request = CompletionRequest.builder()
//                .model("text-davinci-003") // Specify the model
//                .prompt(prompt)
//                .maxTokens(150)
//                .temperature(0.7)
//                .build();
//
//        CompletionResponse response = openAiService.createCompletion(request);
//        return response.getChoices().get(0).getText().trim();
//    }

    public String generateResponse(String prompt) {
        OpenAiService service = new OpenAiService(apiKey);

        ChatMessage userMessage = new ChatMessage("user", "What is the capital of France?");
        OpenAiApi.ChatCompletionRequest request = OpenAiApi.ChatCompletionRequest.builder()
                .model("gpt-4") // Specify the model
                .messages(Arrays.asList(userMessage))
                .build();

        OpenAiApi.ChatCompletionResponse response = service.createChatCompletion(request);
        System.out.println(response.getChoices().get(0).getMessage().getContent());
    }
}
package com.tonycalarese.ai_chatbot.web;

import com.tonycalarese.ai_chatbot.service.AIAgentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agent")
@Slf4j
@RequiredArgsConstructor
public class UserInputOutputController {

    private final AIAgentService aiAgentService;


    @PostMapping("/inquire")
    public ResponseEntity<String> inputText(@RequestBody String userInput){
        log.info("Received Text Input {}", userInput);
        String response = this.aiAgentService.generateResponse(userInput);
        return ResponseEntity.ok(response);
    }
}

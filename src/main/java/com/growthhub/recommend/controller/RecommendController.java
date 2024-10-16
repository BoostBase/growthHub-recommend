package com.growthhub.recommend.controller;

import com.growthhub.recommend.dto.ResponseTemplate;
import com.growthhub.recommend.service.AIService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping
@RequiredArgsConstructor
@Tag(name = "RecommendController", description = "gpt 관련 API")
public class RecommendController {
    private final AIService aiService;

    @GetMapping
    public ResponseEntity<ResponseTemplate<Object>> chat(@RequestParam("prompt") String prompt){
        return aiService.getResponse(prompt);
    }
}

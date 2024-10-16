package com.growthhub.recommend.facade;

import com.growthhub.recommend.service.AIService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class AISearchFacade {
    private final AIService aiService;

}
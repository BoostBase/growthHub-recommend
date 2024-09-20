package com.growthhub.recommend.service;

import com.growthhub.recommend.dto.response.OnboardingInfoResponse;
import com.growthhub.recommend.repository.OnboardingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Component
public class KafkaConsumer {

    private final OnboardingRepository onboardingRepository;

    @Transactional
    @KafkaListener(topics = "onboarding-info", groupId = "recommend-service")
    public void consume(@Payload OnboardingInfoResponse message){
        log.info("user-id: {}", message.userId());
        onboardingRepository.save(message.toOnboarding());
    }
}
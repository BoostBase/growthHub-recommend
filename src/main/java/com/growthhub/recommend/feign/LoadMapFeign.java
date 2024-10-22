package com.growthhub.recommend.feign;

import com.growthhub.recommend.dto.ResponseTemplate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "ROADMAP-SERVICE")
public interface LoadMapFeign {
    @GetMapping("/api/roadmaps/mentors")
    ResponseEntity<ResponseTemplate<Object>> getRoadmapByUsers(
            @RequestParam List<Long> userIds
    );
}
package com.growthhub.recommend.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "USER-SERVICE")
public interface UserFeign {
    @GetMapping("/recommend-user")
    ResponseEntity<List<Long>> getRecommendedUsers(@RequestParam String part);
}
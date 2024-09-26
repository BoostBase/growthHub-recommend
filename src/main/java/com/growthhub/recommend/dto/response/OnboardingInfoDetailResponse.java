package com.growthhub.recommend.dto.response;

import com.growthhub.recommend.domain.type.OnboardingDetailType;

public record OnboardingInfoDetailResponse(
        OnboardingDetailType type,
        String value
) {
}

package com.growthhub.recommend.dto.response;

import com.growthhub.recommend.domain.Onboarding;
import com.growthhub.recommend.domain.type.CompanySize;
import com.growthhub.recommend.domain.type.MentorType;
import com.growthhub.recommend.domain.type.Purpose;
import lombok.Builder;

@Builder
public record OnboardingInfoResponse(
        Long userId,
        CompanySize companySize,
        MentorType mentorType,
        Purpose purpose,
        String onboardingDetail
) {
    public Onboarding toOnboarding() {
        return Onboarding.builder()
                .userId(userId)
                .companySize(companySize)
                .mentorType(mentorType)
                .purpose(purpose)
                .onboardingDetail(onboardingDetail)
                .build();
    }
}

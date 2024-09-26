package com.growthhub.recommend.dto.response;

import com.growthhub.recommend.domain.Onboarding;
import com.growthhub.recommend.domain.OnboardingDetail;
import java.util.List;
import lombok.Builder;

@Builder
public record OnboardingInfoResponse(
        Long userId,
        List<OnboardingInfoDetailResponse> onboardingInfoDetailRequestList
) {
    public Onboarding toOnboarding() {
        // Onboarding 객체 생성
        Onboarding onboarding = Onboarding.builder()
                .userId(userId)
                .build();

        // OnboardingDetail 리스트 생성
        List<OnboardingDetail> details = onboardingInfoDetailRequestList.stream()
                .map(detailRequest -> OnboardingDetail.builder()
                        .onboarding(onboarding) // 현재 Onboarding 객체를 설정
                        .type(detailRequest.type())
                        .value(detailRequest.value())
                        .build())
                .toList();

        // Onboarding 객체의 details 필드에 설정
        onboarding.setDetails(details);

        return onboarding;
    }
}

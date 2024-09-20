package com.growthhub.recommend.repository;

import com.growthhub.recommend.domain.Onboarding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OnboardingRepository extends JpaRepository<Onboarding, Long> {
}

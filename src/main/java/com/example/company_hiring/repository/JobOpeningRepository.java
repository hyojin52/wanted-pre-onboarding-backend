package com.example.company_hiring.repository;

import com.example.company_hiring.entity.JobOpeningEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobOpeningRepository extends JpaRepository<JobOpeningEntity, Integer> {
}

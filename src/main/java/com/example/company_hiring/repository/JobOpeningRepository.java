package com.example.company_hiring.repository;

import com.example.company_hiring.entity.JobOpeningEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobOpeningRepository extends JpaRepository<JobOpeningEntity, Integer> {
  
  List<JobOpeningEntity> findAllByCompanyCompanyId(Integer companyId);
}

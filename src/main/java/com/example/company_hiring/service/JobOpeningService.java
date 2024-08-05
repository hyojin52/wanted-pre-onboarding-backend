package com.example.company_hiring.service;

import com.example.company_hiring.controller.request.JobOpeningCreateRequest;
import com.example.company_hiring.entity.CompanyEntity;
import com.example.company_hiring.entity.JobOpeningEntity;
import com.example.company_hiring.exception.CompanyHiringApplicationException;
import com.example.company_hiring.exception.ErrorCode;
import com.example.company_hiring.repository.CompanyRepository;
import com.example.company_hiring.repository.JobOpeningRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobOpeningService {
  private final CompanyRepository companyRepository;
  private final JobOpeningRepository jobOpeningRepository;
  
  public void create(JobOpeningCreateRequest request) {
    CompanyEntity companyEntity = companyRepository.findById(request.getCompanyId()).orElseThrow(() ->
            new CompanyHiringApplicationException(ErrorCode.COMPANY_NOT_FOUND)
    );
    
    JobOpeningEntity jobOpeningEntity = JobOpeningEntity.builder()
            .company(companyEntity)
            .jobPosition(request.getJobPosition())
            .jobContents(request.getJobContents())
            .signingBonus(request.getSigningBonus())
            .techStack(request.getTechStack())
            .build();
    jobOpeningRepository.save(jobOpeningEntity);
  }
}

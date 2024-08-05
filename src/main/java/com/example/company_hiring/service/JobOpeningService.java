package com.example.company_hiring.service;

import com.example.company_hiring.controller.request.JobOpeningCreateRequest;
import com.example.company_hiring.controller.request.JobOpeningUpdateRequest;
import com.example.company_hiring.controller.response.JobOpeningResponse;
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
  
  public JobOpeningResponse update(Integer id, JobOpeningUpdateRequest request) {
    JobOpeningEntity jobOpeningEntity = jobOpeningRepository.findById(id).orElseThrow(() ->
            new CompanyHiringApplicationException(ErrorCode.JOB_OPENING_NOT_FOUND));
    
    jobOpeningEntity.setJobPosition(request.getJobPosition());
    jobOpeningEntity.setJobContents(request.getJobContents());
    jobOpeningEntity.setSigningBonus(request.getSigningBonus());
    jobOpeningEntity.setTechStack(request.getTechStack());
    JobOpeningEntity savedEntity = jobOpeningRepository.save(jobOpeningEntity);
    return JobOpeningResponse.fromEntity(savedEntity);
  }
  
  public void delete(Integer id) {
    JobOpeningEntity jobOpeningEntity = jobOpeningRepository.findById(id).orElseThrow(() ->
            new CompanyHiringApplicationException(ErrorCode.JOB_OPENING_NOT_FOUND));
    
    jobOpeningRepository.delete(jobOpeningEntity);
  }
  
  public void delete(Integer id) {
    JobOpeningEntity jobOpeningEntity = jobOpeningRepository.findById(id).orElseThrow(() ->
            new CompanyHiringApplicationException(ErrorCode.JOB_OPENING_NOT_FOUND));
    
    jobOpeningRepository.delete(jobOpeningEntity);
  }
  
  public List<JobOpeningListResponse> getAll() {
    List<JobOpeningListResponse> all = jobOpeningRepository.findAll()
            .stream()
            .map(JobOpeningListResponse::fromEntity)
            .collect(Collectors.toList());
    return all;
  }
}

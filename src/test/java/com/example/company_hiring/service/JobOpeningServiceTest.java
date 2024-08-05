package com.example.company_hiring.service;

import com.example.company_hiring.controller.request.JobOpeningCreateRequest;
import com.example.company_hiring.entity.CompanyEntity;
import com.example.company_hiring.entity.JobOpeningEntity;
import com.example.company_hiring.exception.CompanyHiringApplicationException;
import com.example.company_hiring.repository.CompanyRepository;
import com.example.company_hiring.repository.JobOpeningRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class JobOpeningServiceTest {
  
  @Autowired
  private JobOpeningService jobOpeningService;
  
  @MockBean
  private JobOpeningRepository jobOpeningRepository;
  
  @MockBean
  private CompanyRepository companyRepository;
  
  @Test
  void 채용공고_생성_성공() {
    JobOpeningCreateRequest jobOpeningCreateRequest = new JobOpeningCreateRequest(1, "", 500000, "", "");
    
    when(companyRepository.findById(jobOpeningCreateRequest.getCompanyId())).thenReturn(Optional.of(mock(CompanyEntity.class)));
    when(jobOpeningRepository.save(any(JobOpeningEntity.class))).thenReturn(new JobOpeningEntity());
    
    Assertions.assertDoesNotThrow(() -> jobOpeningService.create(jobOpeningCreateRequest));
  }
  
  @Test
  void 채용공고_생성_실패() {
    JobOpeningCreateRequest jobOpeningCreateRequest = new JobOpeningCreateRequest(1, "", 500000, "", "");
    
    when(companyRepository.findById(jobOpeningCreateRequest.getCompanyId())).thenReturn(Optional.empty());
    
    Assertions.assertThrows(CompanyHiringApplicationException.class, () -> jobOpeningService.create(jobOpeningCreateRequest));
  }
}
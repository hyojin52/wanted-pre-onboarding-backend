package com.example.company_hiring.service;

import com.example.company_hiring.controller.request.JobOpeningCreateRequest;
import com.example.company_hiring.controller.request.JobOpeningUpdateRequest;
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

import java.util.List;
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
  
  @Test
  void 채용공고_수정_성공() {
    Integer id = 1;
    JobOpeningUpdateRequest jobOpeningUpdateRequest = new JobOpeningUpdateRequest("백엔드 주니어 개발자", 500000, "원티드랩에서 백엔드 주니어 개발자를 '적극' 채용합니다. 자격요건은..", "Python");
    
    when(jobOpeningRepository.findById(id)).thenReturn(Optional.of(mock(JobOpeningEntity.class)));
    when(jobOpeningRepository.save(any(JobOpeningEntity.class))).thenReturn(new JobOpeningEntity());
    
    Assertions.assertDoesNotThrow(() -> jobOpeningService.update(1, jobOpeningUpdateRequest));
  }
  
  @Test
  void 채용공고_수정_실패() {
    Integer id = 1;
    JobOpeningUpdateRequest jobOpeningUpdateRequest = new JobOpeningUpdateRequest("", 500000, "", "");
    
    when(jobOpeningRepository.findById(id)).thenReturn(Optional.empty());
    
    Assertions.assertThrows(CompanyHiringApplicationException.class, () -> jobOpeningService.update(1, jobOpeningUpdateRequest));
  }
  
  @Test
  void 채용공고_삭제_성공() {
    Integer id = 1;
    
    when(jobOpeningRepository.findById(id)).thenReturn(Optional.of(mock(JobOpeningEntity.class)));
    
    Assertions.assertDoesNotThrow(() -> jobOpeningService.delete(1));
  }
  
  @Test
  void 채용공고_삭제_실패() {
    Integer id = 1;
    
    when(jobOpeningRepository.findById(id)).thenReturn(Optional.empty());
    
    Assertions.assertThrows(CompanyHiringApplicationException.class, () -> jobOpeningService.delete(1));
  }
  
  
  @Test
  void 채용공고_목록_조회_성공() {
    String search = "backend";
    when(jobOpeningRepository.findAll()).thenReturn(List.of());
    
    Assertions.assertDoesNotThrow(() -> jobOpeningService.getAll(search));
  }
  
  @Test
  void 채용공고_상세_조회_성공() {
    Integer id = 1;
    when(jobOpeningRepository.findById(id)).thenReturn(Optional.of(mock(JobOpeningEntity.class)));
    when(jobOpeningRepository.findAllByCompanyCompanyId(id)).thenReturn(List.of(mock(JobOpeningEntity.class)));
    
    Assertions.assertDoesNotThrow(() -> jobOpeningService.getAll());
  }
  
  @Test
  void 채용공고_상세_조회_실패() {
    Integer id = 1;
    when(jobOpeningRepository.findById(id)).thenReturn(Optional.empty());
    
    Assertions.assertThrows(CompanyHiringApplicationException.class, () -> jobOpeningService.get(id));
  }
}
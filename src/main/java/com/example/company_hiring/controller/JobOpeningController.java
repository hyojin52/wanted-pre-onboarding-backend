package com.example.company_hiring.controller;

import com.example.company_hiring.controller.request.JobOpeningCreateRequest;
import com.example.company_hiring.controller.response.Result;
import com.example.company_hiring.service.JobOpeningService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/job-opening")
@RequiredArgsConstructor
public class JobOpeningController {
  private final JobOpeningService jobOpeningService;
  
  @PostMapping
  public Result<Void> create(@RequestBody JobOpeningCreateRequest request) {
    jobOpeningService.create(request);
    return Result.OK();
  }
}

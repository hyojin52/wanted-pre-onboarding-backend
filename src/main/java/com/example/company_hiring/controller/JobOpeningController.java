package com.example.company_hiring.controller;

import com.example.company_hiring.controller.request.JobOpeningCreateRequest;
import com.example.company_hiring.controller.request.JobOpeningUpdateRequest;
import com.example.company_hiring.controller.response.JobOpeningResponse;
import com.example.company_hiring.controller.response.Result;
import com.example.company_hiring.service.JobOpeningService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
  
  @PutMapping("{id}")
  public Result<JobOpeningResponse> update(
          @PathVariable Integer id,
          @RequestBody JobOpeningUpdateRequest request) {
    JobOpeningResponse response = jobOpeningService.update(id, request);
    return Result.OK(response);
  }
}

package com.example.company_hiring.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class JobOpeningCreateRequest {
  private int companyId;
  private String jobPosition;
  private int signingBonus;
  private String jobContents;
  private String techStack;
}

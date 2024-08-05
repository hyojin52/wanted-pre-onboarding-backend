package com.example.company_hiring.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class JobOpeningUpdateRequest {
  private String jobPosition;
  private int signingBonus;
  private String jobContents;
  private String techStack;
}

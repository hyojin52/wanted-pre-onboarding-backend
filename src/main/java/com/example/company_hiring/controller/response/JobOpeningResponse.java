package com.example.company_hiring.controller.response;

import com.example.company_hiring.entity.JobOpeningEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobOpeningResponse {
  private String jobPosition;
  private Integer signingBonus;
  private String jobContent;
  private String techStack;
  
  public static JobOpeningResponse fromEntity(JobOpeningEntity jobOpeningEntity) {
    return JobOpeningResponse.builder()
            .jobPosition(jobOpeningEntity.getJobPosition())
            .signingBonus(jobOpeningEntity.getSigningBonus())
            .jobContent(jobOpeningEntity.getJobContents())
            .techStack(jobOpeningEntity.getTechStack())
            .build();
  }
}

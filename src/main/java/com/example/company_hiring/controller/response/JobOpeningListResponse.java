package com.example.company_hiring.controller.response;

import com.example.company_hiring.entity.JobOpeningEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.batch.BatchProperties;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class JobOpeningListResponse {
  private Integer jobOpeningId;
  private String companyName;
  private String country;
  private String locale;
  private String jobPosition;
  private Integer signingBonus;
  private String techStack;
  
  public static JobOpeningListResponse fromEntity(JobOpeningEntity entity) {
    return JobOpeningListResponse.builder()
            .jobOpeningId(entity.getJobOpeningId())
            .companyName(entity.getCompany().getCompanyName())
            .country(entity.getCompany().getCountry())
            .locale(entity.getCompany().getLocale())
            .jobPosition(entity.getJobPosition())
            .signingBonus(entity.getSigningBonus())
            .techStack(entity.getTechStack())
            .build();
  }
}

package com.example.company_hiring.controller.response;

import com.example.company_hiring.entity.JobOpeningEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class JobOpeningDetailResponse {
  private Integer jobOpeningId;
  private String companyName;
  private String country;
  private String locale;
  private String jobPosition;
  private Integer signingBonus;
  private String techStack;
  private String jobContents;
  private List<Integer> otherJobOpeningIdList;
  
  public static JobOpeningDetailResponse fromEntity(JobOpeningEntity entity, List<Integer> jobOpeningIdList) {
    return JobOpeningDetailResponse.builder()
            .jobOpeningId(entity.getJobOpeningId())
            .companyName(entity.getCompany().getCompanyName())
            .country(entity.getCompany().getCountry())
            .locale(entity.getCompany().getLocale())
            .jobPosition(entity.getJobPosition())
            .signingBonus(entity.getSigningBonus())
            .techStack(entity.getTechStack())
            .jobContents(entity.getJobContents())
            .otherJobOpeningIdList(jobOpeningIdList)
            .build();
  }
}

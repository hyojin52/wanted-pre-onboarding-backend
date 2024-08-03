package com.example.company_hiring.entity;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "job_opening")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JobOpeningEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer jobOpeningId;
  
  @ManyToOne
  @JoinColumn(name="companyId")
  private CompanyEntity company;
  
  @Column(length = 100, nullable = false)
  private String jobPosition;
  
  @Column(nullable = false)
  private int signingBonus;
  
  @Column(length = 1000, nullable = false)
  private String jobContents;
  
  @Column(length = 200, nullable = false)
  private String techStack;
  
  
}

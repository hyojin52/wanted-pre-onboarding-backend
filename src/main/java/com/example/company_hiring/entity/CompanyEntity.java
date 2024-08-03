package com.example.company_hiring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "company")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompanyEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer companyId;
  
  @Column(length = 200, nullable = false)
  private String companyName;
  
  @Column(length = 200, nullable = false)
  private String country;
  
  @Column(length = 200, nullable = false)
  private String locale;
}

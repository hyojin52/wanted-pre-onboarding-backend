package com.example.company_hiring.repository;

import com.example.company_hiring.entity.JobOpeningEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobOpeningRepository extends JpaRepository<JobOpeningEntity, Integer> {
  
  List<JobOpeningEntity> findAllByCompanyCompanyId(Integer companyId);
  
  @Query("SELECT jo FROM JobOpeningEntity jo " +
          "WHERE jo.company.companyName LIKE %:searchTerm% " +
          "OR jo.company.country LIKE %:searchTerm% " +
          "OR jo.company.locale LIKE %:searchTerm% " +
          "OR jo.jobPosition LIKE %:searchTerm% " +
          "OR jo.techStack LIKE %:searchTerm%")
  List<JobOpeningEntity> findBySearchTerm(@Param("searchTerm") String searchTerm);
}

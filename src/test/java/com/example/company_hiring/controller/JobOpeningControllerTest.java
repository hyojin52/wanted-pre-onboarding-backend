package com.example.company_hiring.controller;

import com.example.company_hiring.controller.request.JobOpeningCreateRequest;
import com.example.company_hiring.controller.request.JobOpeningUpdateRequest;
import com.example.company_hiring.service.JobOpeningService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class JobOpeningControllerTest {
  
  @Autowired
  private MockMvc mockMvc;
  
  @Autowired
  private ObjectMapper objectMapper;
  
  @MockBean
  private JobOpeningService jobOpeningService;
  
  @Test
  public void 채용공고_생성_성공() throws Exception {
    JobOpeningCreateRequest jobOpeningCreateRequest = new JobOpeningCreateRequest(1, "", 500000, "", "");
    
    mockMvc.perform(post("/api/v1/job-opening")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsBytes(jobOpeningCreateRequest))
            ).andDo(print())
            .andExpect(status().isOk());
  }
  
  @Test
  public void 채용공고_수정_성공() throws Exception {
    JobOpeningUpdateRequest jobOpeningUpdateRequest = new JobOpeningUpdateRequest( "", 500000, "", "");
    
    mockMvc.perform(put("/api/v1/job-opening/1")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsBytes(jobOpeningUpdateRequest))
            ).andDo(print())
            .andExpect(status().isOk());
  }
  
  @Test
  public void 채용공고_삭제_성공() throws Exception {
    mockMvc.perform(delete("/api/v1/job-opening/1")
                    .contentType(MediaType.APPLICATION_JSON)
            ).andDo(print())
            .andExpect(status().isOk());
  }
  
  @Test
  public void 채용공고_목록_조회_성공() throws Exception {
    mockMvc.perform(get("/api/v1/job-opening")
                    .contentType(MediaType.APPLICATION_JSON)
            ).andDo(print())
            .andExpect(status().isOk());
  }
  
}

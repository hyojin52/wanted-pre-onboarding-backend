# wanted-pre-onboarding-backend
- 기업의 채용을 위한 웹 서비스
- 회사는 채용공고를 생성하고, 이에 사용자는 지원한다.
- 사용언어 및 프레임워크: Java & Spring

## ERD
<img width="476" alt="image" src="https://github.com/user-attachments/assets/60faee7f-c9cb-4668-82ee-0b328f9075e9">

## api 목록
||path|method|설명|
|--|-----|---|---|
|1|/api/v1/job-opening|POST|채용공고 등록|
|2|/api/v1/job-opening/{id}|PUT|채용공고 수정|
|3|/api/v1/job-opening/{id}|DELETE|채용공고 삭제|
|4|/api/v1/job-opening?search={param}|GET|채용공고 목록 조회|
|5|/api/v1/job-opening/{id}|GET|채용공고 상세 조회|




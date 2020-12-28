# 스프링(Spring) 배우기

스프링 부트 배우기 - 1

간단한 로그인, 게시판 구현

## 설계

### 데이터베이스 ERD 설계

![image](https://user-images.githubusercontent.com/50051656/102710036-c33ce980-42f2-11eb-8ebc-9d31fa889ae4.png)

### Entity 설계

![image](https://user-images.githubusercontent.com/50051656/102709986-7527e600-42f2-11eb-84c4-c1bb79358f20.png)

## 개발 기능

### 사용자

- 로그인
- 회원가입
- 회원 목록 보기
- 로그아웃

### 게시판

- 게시글 생성
- 전체 게시글 보기
- 해당 사용자 게시글 보기

## Preview

### 메인페이지

![1](https://user-images.githubusercontent.com/50051656/102710913-49f4c500-42f9-11eb-90a3-e9ba191ed224.PNG)

### 로그인 & 회원가입

![login_signup](https://user-images.githubusercontent.com/50051656/103227681-481ea780-4972-11eb-9bfc-071f1e0c6ab3.PNG)

### 연동 화면

![connect](https://user-images.githubusercontent.com/50051656/103227706-55d42d00-4972-11eb-9239-ac6a84f3c91c.PNG)

### 회원 목록 조회

![4](https://user-images.githubusercontent.com/50051656/102710941-74468280-42f9-11eb-99af-5cf185ea56fc.PNG)

### 게시글 생성

![5](https://user-images.githubusercontent.com/50051656/102710972-abb52f00-42f9-11eb-994c-0c900c49b097.PNG)

### 전체 게시글 보기

![6](https://user-images.githubusercontent.com/50051656/102710979-be2f6880-42f9-11eb-8b80-f4ccec2ec411.PNG)

### 해당 사용자 게시글 보기

![7](https://user-images.githubusercontent.com/50051656/102710981-bf609580-42f9-11eb-9355-e3db87a38a02.PNG)

## 관련 기술

- Spring Boot 2.4.1
- JPA

## 의존 라이브러리

- data-jpa
- thymeleaf
- web
- validation
- security
- lombok
- devtools
- h2

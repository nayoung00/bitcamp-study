# 32_7 - 데이터 처리 코드를 별도의 클래스로 정의하여 객체화 시키기

## 학습목표

- DAO(Data Access Object)의 역할과 이점을 이해한다.
- 데이터 처리 코드를 DAO로 분리할 수 있다.

### DAO ( Data Access Object) 

- 데이터 처리 역할을 수행하는 객체이다.
- 데이터 처리 방식을 캡슐화(추상화 = 클래스로 정의)하여 객체의 사용법을 일관성 있게 만든다.
  - 즉 데이터 처리 방식(배열, 스택, 큐, 맵, 파일, 데이터베이스 등)을 
    클래스로 포장(캡슐화) 하면 데이터 처리 방식에 상관없이 메서드 사용을 통일할 수 있다.
    

## 실습 소스 및 결과


### 훈련 1: 31번 프로젝트에서 데이터를 저장하고 로딩하는 코드를 가져오라.

- com.eomcs.lms.domain 패키지를 생성한다.
- com.eomcs.lms.domain.* 클래스를 가져온다.
- com.eomcs.lms.context 패키지를 생성한다.
- com.eomcs.lms.context.ApplicationContextListener 를 가져온다.
- com.eomcs.lms.DataLoaderListener 를 가져온다.
- ServerApp.java 변경
  - 옵저버를 등록하고, 호출하는 코드를 적용한다.


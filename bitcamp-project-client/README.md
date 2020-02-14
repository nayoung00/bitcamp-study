# 36 - 데이터 관리를 전문 프로그램인 DBMS에게 맡기기

## 학습목표

- 오픈 소스 DBMS 'MariaDB'를 설치할 수 있다.
- DBMS에 사용자와 데이터베이스를 추가할 수 있다.
- 테이블 생성과 예제 데이터를 입력할 수 있다.
- JDBC API의 목적을 이해한다.
  - DBMS와의 통신을 담당하는 proxy 객체의 사용 규칙을 통일하는 것.
- JDBC Driver의 의미를 이해한다.
  - JDBC API 규칙에 따라 정의한 클래스들(라이브러리).
- JDBC API를 활용하여 DBMS에 데이터를 입력, 조회, 변경, 삭제할 수 있다.
- JDBC 프로그래밍 코드를 클래스로 캡슐화 할 수 있다. 

## 실습 소스 및 결과

- src/main/java/com/eomcs/lms/dao/proxy/Worker.java 추가
- src/main/java/com/eomcs/lms/dao/proxy/DaoProxyHelper.java 추가
- src/main/java/com/eomcs/lms/dao/proxy/XxxDaoProxy.java 추가
- src/main/java/com/eomcs/lms/ClientApp.java 변경


## 실습  

### 훈련 1: 

- com.eomcs.lms.dao.proxy.XxxDaoProxy 변경한다.
  - 요청할 때 서버에 연결한다.

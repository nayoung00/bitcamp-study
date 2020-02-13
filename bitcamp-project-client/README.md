# 33_3 - 리팩토링: 서버 연결 부분을 캡슐화하기

## 학습목표

- 리팩토리의 목적을 이해한다.

## 실습 소스 및 결과

- src/main/java/com/eomcs/lms/dao/proxy/Worker.java 추가
- src/main/java/com/eomcs/lms/dao/proxy/DaoProxyHelper.java 추가
- src/main/java/com/eomcs/lms/dao/proxy/XxxDaoProxy.java 추가
- src/main/java/com/eomcs/lms/ClientApp.java 변경


## 실습  

### 훈련 1: 서버와 통신을 담당할 실제 작업의 규칙을 정의하라.

- com.eomcs.lms.dao.proxy.XxxDaoProxy 변경한다.
  - 요청할 때 서버에 연결한다.

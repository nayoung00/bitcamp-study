// dynamic sql 다루기 - <where> 사용 전 : 조건이 빠졌을 때 문제 발생 해결책
package com.eomcs.mybatis.ex03;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam0150 {

  public static void main(String[] args) throws Exception {
    InputStream inputStream =
        Resources.getResourceAsStream("com/eomcs/mybatis/ex03/mybatis-config.xml");
    SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = factory.openSession();

    // 여러개의 조건을 합쳐서 검색하기.
    HashMap<String, Object> params = new HashMap<>();

    Scanner keyScan = new Scanner(System.in);

    System.out.println("번호? ");
    String value = keyScan.nextLine();
    if (value.length() > 0) {
      params.put("no", value);
    }

    System.out.println("제목? ");
    value = keyScan.nextLine();
    if (value.length() > 0) {
      params.put("title", value);
    }

    System.out.println("내용? ");
    String content = keyScan.nextLine();
    value = keyScan.nextLine();
    if (value.length() > 0) {
      params.put("contents", value);
    }
    keyScan.close();


    List<Board> list = sqlSession.selectList("BoardMapper.select6", params);
    // select5 의 문제점
    // => no 값이 없을 경우 잘못된 SQL문을 생성한다.
    // => 생성된

    for (Board board : list) {
      System.out.printf("%d, %s, %s, %s, %d\n", board.getNo(), board.getTitle(), board.getContent(),
          board.getRegisteredDate(), board.getViewCount());
    }
    sqlSession.close();
  }
}

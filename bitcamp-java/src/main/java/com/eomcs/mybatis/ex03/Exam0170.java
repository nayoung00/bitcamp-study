// dynamic sql 다루기 - <trim> 사용법
package com.eomcs.mybatis.ex03;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam0170 {

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


    List<Board> list = sqlSession.selectList("BoardMapper.select8", params);

    // select8:
    // => <where> 대신에 <trim>을 사용하여 불필요한 SQL 코드 제거.
    // => or/and

    for (Board board : list) {
      System.out.printf("%d, %s, %s, %s, %d\n", board.getNo(), board.getTitle(), board.getContent(),
          board.getRegisteredDate(), board.getViewCount());
    }
    sqlSession.close();
  }
}

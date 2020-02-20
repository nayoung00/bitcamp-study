// 게시판 관리 - 등록
package com.eomcs.jdbc.ex2.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

// 다음과 같이 게시물을 등록하는 프로그램을 작성하라!
// ----------------------------
// 제목? aaa
// 내용? bbb
// 등록하시겠습니까?(Y/n) y
// 등록하였습니다.
// 등록하시겠습니까?(Y/n) n
// 등록을 취소 하였습니다.
// ----------------------------
public class Exam0110 {
  public static void main(String[] args) throws Exception {

    String title = null;
    String contents = null;

    try (Scanner keyScan = new Scanner(System.in)) {

      System.out.print("제목?");
      title = keyScan.nextLine();

      System.out.println("내용?");
      contents = keyScan.nextLine();

      System.out.println(" 입력하시겠습니까?(Y/N)");
      String input = keyScan.nextLine();

      if (!input.equalsIgnoreCase("y") && input.length() != 0) {
        System.out.println("등록을 취소하였습니다.");
        return;
      }
      try (Connection con = DriverManager.getConnection( //
          "jdbc:mysql://localhost:3306/studydb?user=study&password=1111");


          PreparedStatement stmt =
              con.prepareStatement("insert into x_board(title,contents) values(?,?)");) {

        stmt.setString(1, title);
        stmt.setString(2, contents);

        int count = stmt.executeUpdate();
        System.out.printf(" %d 개 입력 성공!", count);
      }
    }
  }
}

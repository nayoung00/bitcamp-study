// 사용자 입력을 받는 코드를 별도의 메서드로 분리한다.
//
package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.eomcs.lms.dao.LessonDao;

public class LessonListCommand implements Command {
  LessonDao lessonDao;

  public LessonListCommand(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }

  @Override
  public void execute() {
    try {

      // List<Lesson> lessons = lessonDao.findAll();

      Class.forName("org.mariadb.jdbc.Driver");

      Connection con =
          DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");

      Statement stmt = con.createStatement();

      ResultSet rs = stmt
          .executeQuery("select lesson_id, sdt, edt, tot_hr, day_hr, titl, conts from lms_lesson");

      while (rs.next()) {
        System.out.printf("%d, %s ~ %s, %d, %d, %s, %s\n", rs.getInt("lesson_id"),
            rs.getDate("sdt"), rs.getDate("edt"), rs.getInt("tot_hr"), rs.getInt("day_hr"),
            rs.getString("titl"), rs.getString("conts"));
      }
      rs.close();
      stmt.close();
      con.close();

    } catch (Exception e) {
      System.out.println("목록 조회 실패!");
    }
  }
}


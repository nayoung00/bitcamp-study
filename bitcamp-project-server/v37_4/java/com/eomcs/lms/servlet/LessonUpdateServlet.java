package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonUpdateServlet implements Servlet {

  LessonDao lessonDao;

  public LessonUpdateServlet(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {

    out.println("번호? \n!{}!");
    out.flush();
    int no = Integer.parseInt(in.nextLine());

    Lesson old = lessonDao.findByNo(no);

    if (old == null) {
      out.println("해당 번호의 수업이 없습니다.");
      return;
    }
    Lesson lesson = new Lesson();
    lesson.setNo(no);

    out.printf("수업(%s)? \n!{}!\n", old.getTitle());
    lesson.setTitle(in.nextLine());

    out.printf("설명(%s)? \n!{}!\n", old.getDescription());
    lesson.setDescription(in.nextLine());

    out.printf("시작일(%s)? \n!{}!\n", old.getStartDate());
    lesson.setStartDate(Date.valueOf(in.nextLine()));

    out.printf("종료일(%s)? \n!{}!\n", old.getEndDate());
    lesson.setEndDate(Date.valueOf(in.nextLine()));

    out.printf("총수업시간(%d)? \n!{}!\n", old.getTotalHours());
    lesson.setTotalHours(in.nextInt());

    out.printf("일수업시간(%d) \n!{}!\n", old.getDayHours());
    lesson.setDayHours(in.nextInt());

    out.flush();

    if (lessonDao.update(lesson) > 0) { // 변경했다면,
      out.println("수업을 변경했습니다.");
    } else {
      out.println("수업 변경에 실패했습니다.");
    }
  }
}


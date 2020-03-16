package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;
import com.eomcs.util.Component;
import com.eomcs.util.Prompt;

@Component("/lesson/add")
public class LessonAddServlet implements Servlet {

  LessonService lessonService;

  public LessonAddServlet(LessonService lessonService) {
    this.lessonService = lessonService;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    Lesson lesson = new Lesson();

    lesson.setTitle(Prompt.getString(in, out, "강의명?"));
    lesson.setDescription(Prompt.getString(in, out, "설명? "));
    lesson.setStartDate(Prompt.getDate(in, out, "시작일?"));
    lesson.setEndDate(Prompt.getDate(in, out, "종료일?"));
    lesson.setTotalHours(Prompt.getInt(in, out, "총수업시간?"));
    lesson.setDayHours(Prompt.getInt(in, out, "일수업시간?"));

    if (lessonService.insert(lesson) > 0) {
      out.println("새 수업을 등록 했습니다.");
    } else {
      out.println("수업 등록에 실패했습니다.");
    }
  }
}

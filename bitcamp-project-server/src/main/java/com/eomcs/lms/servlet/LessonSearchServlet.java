package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;
import com.eomcs.util.Component;
import com.eomcs.util.Prompt;

@Component("/lesson/search")
public class LessonSearchServlet implements Servlet {
  LessonService lessonService;

  public LessonSearchServlet(LessonService lessonService) {
    this.lessonService = lessonService;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {

    HashMap<String, Object> params = new HashMap<>();

    String keyword = Prompt.getString(in, out, "강의명 검색:");
    if (keyword.length() > 0) {
      params.put("title", keyword);
    }

    Date date = Prompt.getDate(in, out, "시작일 검색:");
    if (date != null) {
      params.put("stratDate", date);
    }

    date = Prompt.getDate(in, out, "종료일 검색:");
    if (date != null) {
      params.put("endDate", date);
    }

    int value = Prompt.getInt(in, out, "총 강의시간 검색:");
    if (value > 0) {
      params.put("totalHours", value);
    }

    value = Prompt.getInt(in, out, "일 강의시간 검색:");
    if (value > 0) {
      params.put("dayHours", value);
    }

    out.println("---------------------------------");
    out.println("[검색결과]");
    out.println();

    List<Lesson> lessons = lessonService.findByKeyword(params);
    for (Lesson l : lessons) {
      out.printf("%d, %s, %s ~ %s, %d\n", l.getNo(), l.getTitle(), l.getStartDate(), l.getEndDate(),
          l.getTotalHours());
    }
  }
}

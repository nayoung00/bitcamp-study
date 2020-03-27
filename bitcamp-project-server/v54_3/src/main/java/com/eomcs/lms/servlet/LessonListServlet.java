package com.eomcs.lms.servlet;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;
import com.eomcs.util.RequestMapping;

@Component
public class LessonListServlet {
  LessonService lessonService;

  public LessonListServlet(LessonService lessonService) {
    this.lessonService = lessonService;
  }

  @RequestMapping("/lesson/list")
  public void service(Map<String, String> params, PrintWriter out) throws Exception {

    out.println("<!DOCTYPE html>");
    out.println(" <html>");
    out.println(" <head>");
    out.println("<meta charset='UTF-8'>");
    out.println(" <title>강의 목록</title>");
    out.println(" <body>");
    out.println("<h1>강의</h1>");
    out.println("</body>");
    out.println("<a href='/lesson/addForm'> 새 강의 </a><br>");
    out.println(" <table border='14'>");
    out.println(" <tr>");
    out.println("<th>번호</th>");
    out.println("<th>제목</th>");
    out.println("<th>시작일</th>");
    out.println("<th>종료일</th>");
    out.println("<th>총시간</th>");
    out.println(" </tr>");

    List<Lesson> lessons = lessonService.findAll();
    for (Lesson l : lessons) {
      out.printf(
          "<tr><td>%d</td> <td><a href='/lesson/detail?no=%d'>%s</a></td> <td>%s</td> ~ <td>%s</td> <td>%d</td></tr>\n",
          l.getNo(), l.getNo(), l.getTitle(), l.getStartDate(), l.getEndDate(), l.getTotalHours());
    }
  }
}

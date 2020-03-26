package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.lms.service.LessonService;
import com.eomcs.util.RequestMapping;

@Component
public class LessonDeleteServlet {

  LessonService lessonService;

  public LessonDeleteServlet(LessonService lessonService) {
    this.lessonService = lessonService;
  }

  @RequestMapping("/lesson/delete")
  public void service(Map<String, String> params, PrintStream out) throws Exception {

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<meta http-equiv='refresh' content='2;url=/board/list'>");
    out.println("<title>수업 삭제</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>수업 삭제 결과</h1>");


    int no = Integer.parseInt(params.get("no"));

    if (lessonService.delete(no) > 0) {
      out.println("<p>수업을 삭제했습니다.</p>");

    } else {
      out.println("<p>해당 번호의 수업이 없습니다.</p>");
    }

    out.println("</body>");
    out.println("</html>");
  }
}

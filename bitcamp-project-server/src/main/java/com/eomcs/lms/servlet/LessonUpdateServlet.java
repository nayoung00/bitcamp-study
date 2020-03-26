package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.sql.Date;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;
import com.eomcs.util.RequestMapping;

@Component
public class LessonUpdateServlet {

  LessonService lessonService;

  public LessonUpdateServlet(LessonService lessonService) {
    this.lessonService = lessonService;
  }

  @RequestMapping("/lesson/update")
  public void service(Map<String, String> params, PrintStream out) throws Exception {

    Lesson lesson = new Lesson();
    lesson.setNo(Integer.parseInt(params.get("no")));
    lesson.setTitle(params.get("title"));
    lesson.setDescription(params.get("description"));
    lesson.setStartDate(Date.valueOf(params.get("startDate")));

    lesson.setEndDate(Date.valueOf(params.get("endDate")));
    lesson.setTotalHours(Integer.parseInt(params.get("totalHours")));
    lesson.setDayHours(Integer.parseInt(params.get("dayHours")));


    if (lessonService.update(lesson) > 0) { // 변경했다면,
      out.println("<p>수업을 변경했습니다.</p>");
    } else {
      out.println("<p>수업 변경에 실패했습니다.</p>");
    }
    out.println("</body>");
    out.println("</html>");
  }
}


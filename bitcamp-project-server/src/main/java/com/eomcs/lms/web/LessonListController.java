package com.eomcs.lms.web;

import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;
import com.eomcs.util.RequestMapping;

@WebServlet
public class LessonListController {

  @Autowired
  LessonService lessonService;

  @RequestMapping("/lesson/list")
  protected String list(HttpServletRequest request, HttpServletResponse response) throws Exception {

    List<Lesson> lessons = lessonService.list();
    request.setAttribute("list", lessons);
    return "/lesson/list.jsp";

  }
}

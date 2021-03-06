package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;
import com.eomcs.util.Component;
import com.eomcs.util.Prompt;
import com.eomcs.util.RequestMapping;

@Component
public class LessonUpdateServlet {

  LessonService lessonService;

  public LessonUpdateServlet(LessonService lessonService) {
    this.lessonService = lessonService;
  }

  @RequestMapping("/lesson/update")
  public void service(Scanner in, PrintStream out) throws Exception {

    int no = Prompt.getInt(in, out, "번호? ");

    Lesson old = lessonService.findByNo(no);

    if (old == null) {
      out.println("해당 번호의 수업이 없습니다.");
      return;
    }
    Lesson lesson = new Lesson();
    lesson.setNo(no);

    lesson.setTitle(Prompt.getString(in, out, String.format("강의명(%s)? \n", old.getTitle())));

    lesson
        .setDescription(Prompt.getString(in, out, String.format("설명(%s)? ", old.getDescription())));

    lesson
        .setStartDate(Prompt.getDate(in, out, String.format("강의 시작일(%s)? \n", old.getStartDate())));

    lesson.setEndDate(Prompt.getDate(in, out, String.format("종료일(%s)?", old.getEndDate())));

    lesson.setTotalHours(
        Prompt.getInt(in, out, String.format("총 강의시간(%d)? \n", old.getTotalHours())));
    lesson.setDayHours(Prompt.getInt(in, out, String.format("일 강의시간(%d)? \n", old.getDayHours())));

    out.flush();

    if (lessonService.update(lesson) > 0) { // 변경했다면,
      out.println("수업을 변경했습니다.");
    } else {
      out.println("수업 변경에 실패했습니다.");
    }
  }
}


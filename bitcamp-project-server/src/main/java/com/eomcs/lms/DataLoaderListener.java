package com.eomcs.lms;

import java.util.Map;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.dao.BoardFileDao;
import com.eomcs.lms.dao.LessonFileDao;
import com.eomcs.lms.dao.MemberFileDao;

// 애플리케이션이 시작되거나 종료될 때
// 데이터를 로딩하고 저장하는 일을 한다.
//
public class DataLoaderListener implements ApplicationContextListener {


  @Override
  public void contextInitialized(Map<String, Object> context) {
    System.out.println("데이터를 로딩합니다.");


    // 애플리케이션이 시작되면 이 메서드가 호출될 것이고,
    // 이 메서드에서는 애플리케이션에서 사용할 데이터를 로딩하는 일을 한다.

    BoardFileDao boardDao = new BoardFileDao("./board.ser2");
    LessonFileDao lesssonDao = new LessonFileDao("./lesson.ser2");
    MemberFileDao memberDao = new MemberFileDao("./member.ser2");

    // 이 메서드를 호출한 쪽(App)에서 DAO를
    // 사용할 수 있도록 Map 객체에 담아둔다.
    context.put("boardDao", boardDao);
    context.put("lessonDao", lesssonDao);
    context.put("memberDao", memberDao);
  }

  @Override
  public void contextDestroyed(Map<String, Object> context) {
    System.out.println("데이터를 저장합니다.");
  }

}

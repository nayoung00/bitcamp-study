package com.eomcs.lms;

import com.eomcs.lms.context.ApplicationContextListener;

// 애플리케이션이 시작되거나 종료될때
// 데이터를 로딩하고 저장하는 일을 한다.
//
public class DataLoaderaListener implements ApplicationContextListener {

  @Override
  public void contextInitialized() {
    System.out.println("데이터를 로딩합니다.");
  }

  @Override
  public void contextDestroyed() {
    System.out.println("데이터를 저장합니다.");
  }

}

package com.eomcs.oop.ex09.g;

public class Exam0120 implements A {

  @Override
  public void m1() {
    // 인터페이스의 추상 메서드는 반드시 구현해야 한다.
    // 구현하지 않으면 추상 메서드인채로 남아 있기 때문에
    // 클래스는 일반 클래스(concrete class)가 될 수 없다.
    // 추상 클래스가 되어야 한다.

  }

  @Override
  public void m2() {
    // default 메서드는 인터페이스에서 구현했기 때문에
    // 클래스에서는 구현하지 않아도 컴파일 오류가 발생하지 않는다.

  }
}

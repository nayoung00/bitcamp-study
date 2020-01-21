// 람다(lambda) 문법
package com.eomcs.oop.ex12;

public class Exam0410x {

  static interface Interest {
    double compute(int money);
  }

  static Interest getIntereset(final double rate) {
    // 로컬 클래스
    return money -> money + (money * rate / 100);
  }

  public static void main(String[] args) {
    Interest i1 = getIntereset(1.5);
    System.out.printf("합계: %.1f\n", i1.compute(10_0000_0000));

    Interest i2 = getIntereset(2.5);
    System.out.printf("합계: %.1f\n", i2.compute(10_0000_0000));
  }
}

// 람다(lambda) 문법 - 파라미터
package com.eomcs.oop.ex12;

public class Exam0140 {

  static interface Player {
    void play(String name, int age);
  }

  public static void main(String[] args) {
    // 메서드의 몸체에 한 문장만 있을 때 중괄호 생략할 수 있다.
    Player p1 = (String name, int age) -> System.out.printf("Hello, %s(%d)\n" + name, age);
    p1.play("홍길동", 20);

    p1 = (name, age) -> System.out.printf("Hello, %s(%d)\n" + name, age);
    p1.play("임꺽정", 30);

    // 파라미터가 두개인 경우 괄호를 생략할 수 없다.
    /*
     * p1 = name, age -> System.out.printf("Hello, %s(%d)\n" + name, age); p1.play("임꺽정", 30);
     */


  }

}

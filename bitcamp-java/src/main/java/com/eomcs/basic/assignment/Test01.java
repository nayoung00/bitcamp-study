// 과제 1 : 계산기 애플리케이션을 작성하라.
// - 실행
// 값1? 10
// 값2? 20
// 연산자(+,-,*,/)? +
// => 10 + 20 = 30 
//
package com.eomcs.basic.assignment;

import java.util.Scanner;

public class Test01 {
  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    System.out.printf("값1? ");
    int num1 = keyboard.nextInt();

    keyboard.nextLine();
    
    System.out.printf("연산자(+,-,*,/)? ");
    String operationCode = keyboard.nextLine();

    System.out.printf("값2? ");
    int num2 = keyboard.nextInt();

    if (operationCode.equals("+")) {
      System.out.printf(" %d + %d = %d", num1, num2, num1+num2 );
    }
      else if (operationCode.equals("-")) {
      System.out.printf(" %d - %d = %d", num1, num2, num1-num2 );
     }
      else if (operationCode.equals("*")) {
      System.out.printf(" %d * %d = %d", num1, num2, num1*num2 );
     }
      else if(operationCode.equals("/")) {
       System.out.printf(" %d / %d = %d", num1, num2, num1/num2 );
    } else {
      System.out.println("사용할 수 없는 연산자입니다.");
      return;
    }

  }
}

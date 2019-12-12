// 과제 1 : 계산기 애플리케이션을 작성하라.
// - 실행
// 값1? 10
// 값2? 20
// 연산자(+,-,*,/)? +
// => 10 + 20 = 30 
//
package com.eomcs.basic.ex04.assignment;

import java.util.Scanner;

public class Test01 {
  public static void main(String[] args) {
    char[] operationCode = {'+', '-', '*', '/', '(', ')'}; //연산 부호

    Scanner keyboard = new Scanner(System.in);

    System.out.print("값1? ");
    Int input1 = keyboard.nextint();

    System.out.print("연산자(+,-,*,/)? ");
    String input2 = keyboard.nextLine();

    System.out.print("값2? ");
    Int input3 = keyboard.nextInt();

    int num1 = Integer.parseInt(input1);
    int num2 = Integer.parseInt(input2);
    
    if ( input2.equals("+")) {
      int result= num1 + num2;
       System.out.println(result);
      }

      elseif ( input2.equals("-")) {
       int result1 = num1 - num2;
        System.out.println(result);
       }

      elseif ( input2.equals("*")) {
        int result2 = num1 * num2;
         System.out.println(result);
        }

      elseif ( input2.equals("/")) {
        int result3 = num1 / num2;
         System.out.println(result);
        }



  }
}

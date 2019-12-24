package com.eomcs.basic.ex07.assignment;

import java.util.Scanner;

// 과제: 재귀호출을 이용하여 직삼각형을 출력하라.
// 실행)
// 밑변의 길이? 5
// *
// **
// ***
// ****
// *****

public class Test05 {
  public static void main(String[] args) {
    // 사용자로부터 밑변의 길이를 입력 받는다.

    Scanner sc = new Scanner(System.in);
    int base;
    do {
      System.out.print("밑변의 길이?");
      base = sc.nextInt();
    } while (base <= 0);

    printTriangle(base);
  }

  static void printTriangle(int base) {
    for (int i = 1; i <= base; i++) {                             
      for (int j = 1; j <= i; j++) {            
        System.out.print("*");         
      }
      System.out.println();                  
    }
  }
}
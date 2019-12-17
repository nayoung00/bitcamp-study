//# 과제(2019-12-17)
/*사용자로부터 마름모의 가로 길이를 숫자를 입력 받아 '*' 문자로 그려라. 단 마름모의 절반만 그린다.

## 구현 조건
반복문을 사용할 때는 while 또는 do ~ while 문만을 사용하라!

## 실행 결과
```
밑변 길이? 5
 *
 **
 ***
 ***
 *****
 ****
 ***
 **
 *
```*/ 

package com.eomcs.basic.assignment;

import java.util.Scanner;

public class test1217_02 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.printf("밑변길이? ");
    int len = sc.nextInt();

    int a = 1;
    while ( a <= len ) {      
      int b = 1;
      while ( b <= a ) {
        System.out.print("*");
        b++;
      }
      System.out.println("");
      a++;
    }

    a = len - 1;
    while ( a >= 1) {
      int c = 1;
      while ( c <= a ) {
        System.out.print("*");
        c++;
      }
      System.out.println("");
      a--;       
    }

  }
}

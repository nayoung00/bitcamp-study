//#
//사용자로부터 직삼각형의 밑변 숫자를 입력 받아 '*' 문자로 그려라. 
//## 구현 조건
//반복문을 사용할 때는 while 또는 do ~ while 문만을 사용하라!
//## 실행 결과
//밑변 길이? 5
//*
//**
//***
//****
//*****

package com.eomcs.basic.assignment;

import java.util.Scanner;

public class test1217_01 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);   

    System.out.printf("밑변의 길이?\n");
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

  }
}


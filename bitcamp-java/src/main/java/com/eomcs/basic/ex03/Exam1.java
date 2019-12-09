package com.eomcs.basic.ex03;

// 리터럴

public class Exam1 {
  public static void main(String[] args) {
    // 정수 리터럴
    System.out.println(78); //10진수 표기법
    //78이 정수 리터럴 이다.
    System.out.println(78); //10진수 표기법
    System.out.println(-78); //10진수 표기법

    System.out.println(0116); //8진수 표기법
    System.out.println(-0116); //8진수 표기법 

    System.out.println(0x4e); //16진수 표기법 
    System.out.println(-0x4e); //16진수 표기법 

    System.out.println(0b01001110); //2진수 표기법 
    System.out.println(-0b01001110); //2진수 표기법 

    // 부동 소수점 리터럴
    System.out.println(3.14); // 고정 소수점
    System.out.println(0.314e1); // 부동 소수점
    System.out.println(31.4e-1); 

    // 논리 리터럴
    System.out.println(true);
    System.out.println(false);
  

    // 문자 리터럴
    System.out.println('A');
    System.out.println('가');

    // 문자열 리터럴
    System.out.println("안녕하세요! 비트캠프!");


  }
}
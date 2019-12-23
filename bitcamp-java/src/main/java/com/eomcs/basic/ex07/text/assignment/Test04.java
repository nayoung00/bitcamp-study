package com.eomcs.basic.ex07.text.assignment;

import java.util.Scanner;

// 과제: 재귀호출을 이용하여 n! 을 계산하라.
// 실행)
// 입력? 5
// 5! = 1 * 2 * 3 * 4 * 5 = 120
//
public class Test04 {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("입력? ");
    int n = sc.nextInt();
    
    System.out.printf("%d! = ", n);
    int result = factorial(n);
    
    System.out.printf("%d",result); 
  }
    
  static int factorial(int n) {   
    if (n <= 1) {
      System.out.printf("%d = ",n);
      return 1;
    }
    else {
      System.out.printf("%d * ",n);
      return n*factorial(n-1);
    }
  }
}
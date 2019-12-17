//#과제1 : 입력 받은 두 정수 사이의 합계를 구하라.
//실행 예)
//입력? 2 5 
//2에서 5까지의 합은 14입니다.

package com.eomcs.basic.assignment;

import java.util.Scanner;

public class T01{
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    System.out.print("입력? ");
    int a = keyboard.nextInt();
    int b = keyboard.nextInt();

    int sum = 0;

    for(int i = a; i<=b ;i++)       
      sum += i;

    System.out.printf("%d 에서 %d 까지의 합은  %d 입니다.\n", a, b, sum);   

    keyboard.close();

  }
}
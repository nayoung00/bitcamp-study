package com.eomcs.basic.ex04.assignment;

import java.util.Scanner;

public class T01{
  public static void main(String[] args) {
    
    Scanner keyboard = new Scanner(System.in);

    System.out.print("입력? ");
    int a = keyboard.nextInt();
    int b = keyboard.nextInt();

    int sum = 0;

    for(int i = a;i<b+1;i++)
      
     sum += i;
    
        System.out.printf("%d 에서 %d 까지의 합은  %d 입니다.", a, b, sum);

       
  }
}
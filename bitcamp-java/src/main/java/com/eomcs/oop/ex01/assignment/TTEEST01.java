package com.eomcs.oop.ex01.assignment;

import java.util.Scanner;

public class TTEEST01 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    
   System.out.println("입력? ");
   int a = keyboard.nextInt();
   int b = keyboard.nextInt();
   
   int sum = 0;
   
   for(int i = a; i<=b ; i++)
     sum += i;
   
   System.out.printf("%d 에서 %d 까지의 합은 %d 입니다.\n", a, b, sum);
   
   keyboard.close();
   
  }
}

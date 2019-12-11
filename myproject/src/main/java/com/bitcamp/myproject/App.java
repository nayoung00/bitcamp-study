
package com.bitcamp.myproject;

import java.util.Scanner;

public class App {
  

  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());
    
    System.out.print("요리? ");
    String cook = keyboard.nextLine();
    
    System.out.print("재료? ");
    String material = keyboard.nextLine();
    
    System.out.print("방법? ");
    String method = keyboard.nextLine();
    
    System.out.print("비용? ");
    int expense = Integer.parseInt(keyboard.nextLine());
    
    System.out.print("시간? ");
    int time = Integer.parseInt(keyboard.nextLine());
    
    
    System.out.println(); 
    
    
    System.out.printf("번호: %s\n", no); 
    System.out.printf("요리: %s\n", cook);
    System.out.printf("재료: %s\n", material);
    System.out.printf("방법: %s\n", method);
    System.out.printf("비용: %s 원 \n", expense);
    System.out.printf("시간: %s 분 \n ", time);

    keyboard.close();
  }
}

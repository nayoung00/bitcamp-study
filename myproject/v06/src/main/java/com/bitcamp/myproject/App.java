package com.bitcamp.myproject;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    
    int[] no = new int[100];
    String[] cook = new String[100];
    String[] material = new String[100];
    String[] method = new String[100];
    int[] expense = new int[100];
    int[] time = new int[100];
    String response;
    
    int count = 0;
    for (int i = 0; i < 100; i++) {
      System.out.print("번호? ");
      no[i] = keyboard.nextInt();
      keyboard.nextLine();
      
      System.out.print("요리? ");
      cook[i] = keyboard.nextLine();
      
      System.out.print("재료? ");
      material[i] = keyboard.nextLine();
      
      System.out.print("방법? ");
      method[i] = keyboard.nextLine();
      
      System.out.print("비용? ");
      expense[i] = keyboard.nextInt();
      keyboard.nextLine();
      
      System.out.print("시간? ");
      time[i] = keyboard.nextInt();
      keyboard.nextLine();
      
      count++;;
      
      System.out.println(); 
      
      System.out.print("계속 입력하시겠습니까?(Y/n) ");
      response = keyboard.nextLine();
      if (!response.equalsIgnoreCase("y")) {
        break; 
      }  
      
    }   
    keyboard.close();
    
    System.out.println();
    
    for (int i = 0; i <count; i++) {
      System.out.printf("%d, %s, %s, %s, %d, %d\n", 
          no[i], cook[i], material[i], method[i], expense[i], time[i]);
    }
  }
}
package com.eomcs.lms;

import java.util.Scanner;

public class App3 {
  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);
    
    System.out.print("번호? ");
    String no = keyboard.nextLine();
    System.out.print("내용? ");
    String contents = keyboard.nextLine();
    
    
    
    System.out.printf("번호: %s\n", no);
    System.out.printf("내용: %s\n", contents);
    System.out.printf("작성일: 2019-01-01");
    System.out.printf("조회수: 0");

  }
}

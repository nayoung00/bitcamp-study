package com.eomcs.lms;

import java.util.Scanner;

public class App3 {
  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);
    
    System.out.print("번호? ");
    String no = keyboard.nextLine();
    System.out.print("내용? ");
    String contents = keyboard.nextLine();
    
    
    
    System.out.println("번호: %s\n", no);
    System.out.println("내용: %s\n", contents);
    System.out.println("작성일: 2019-01-01");
    System.out.println("조회수: 0");

  }
}

package com.eomcs.lms;

import java.util.Scanner;
import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;
import com.eomcs.util.Prompt;


public class App {

  static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) {
    
    Prompt prompt = new Prompt(keyboard);
    
    BoardHandler BoardHandler = new BoardHandler(prompt);
    LessonHandler LessonHandler = new LessonHandler(prompt);
    MemberHandler MembmerHandler = new MemberHandler(prompt);

    String command;

    do {
      System.out.print("\n명령> ");
      command = keyboard.nextLine();

      switch (command) {
        case "/lesson/add":        
          // 다른 클래스로 분리한 메서드를 호출할 때는 
          // 클래스 이름을 지정해야한다. 
          LessonHandler.addLesson();
          break;
        case "/lesson/list":
          LessonHandler.listLesson();
          break;
        case "/lesson/detail":
          LessonHandler.detailLesson();
          break;  
        case "/lesson/update":
          LessonHandler.updateLesson();
          break; 
        case "/lesson/delete":
          LessonHandler.deleteLesson();
          break; 
        case "/member/add":
          MembmerHandler.addMember();
          break;
        case "/member/list":
          MembmerHandler.listMember();
          break;
        case "/member/detail":
          MembmerHandler.detailMember();
          break;
        case "/member/update":
          MembmerHandler.updateMember();
          break;
        case "/member/delete":
          MembmerHandler.deleteMember();
          break;
        case "/board/add":
          BoardHandler.addBoard();
          break;
        case "/board/list":
          BoardHandler.listBoard();
          break;
        case "/board/detail":
          BoardHandler.detailBoard();
          break;
        case "/board/update":
          BoardHandler.updateBoard();
          break;
        case "/board/delete":
          BoardHandler.deleteBoard();
          break;
        default:
          if (!command.equalsIgnoreCase("quit")) {
            System.out.println("실행할 수 없는 명령입니다.");
          }
      }
    } while (!command.equalsIgnoreCase("quit"));

    System.out.println("안녕!");

    keyboard.close();
  }
}
package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;
import com.eomcs.util.ArrayList;

public class BoardHandler {

  ArrayList<Board> boardList;
  Scanner input;

  public BoardHandler(Scanner input) {
    this. input = input;
    this.boardList = new ArrayList<>();
  }

  public BoardHandler(Scanner input, int capacity) {
    this.input = input;
    boardList = new ArrayList<>(capacity);
  }

  public void listBoard() {
    // BoardList의 배열에 보관된 값을 받을 배열을 준비한다.
    Board[] arr = new Board[this.boardList.size()]; 

    // toArray()에게 빈 배열을 넘겨서 복사 받는다. 
    this.boardList.toArray(arr);

    for (Board b : arr) {
      System.out.printf("%d, %s, %s, %d\n", 
          b.getNo(), b.getTitle(), b.getDate(), b.getViewCount());
    }   
  } 

  public void addBoard() {
    Board board = new Board();

    System.out.print("번호? ");
    board.setNo(input.nextInt());
    input.nextLine(); // 줄바꿈 기호 제거용

    System.out.print("내용? ");
    board.setTitle(input.nextLine());

    board.setDate(new Date(System.currentTimeMillis()));
    board.setViewCount(0);

    this.boardList.add(board);

    System.out.println("저장하였습니다.");
  }

  public void detailBoard() {
    System.out.println("게시글 인덱스? ");
    int index = input.nextInt();
    input.nextLine(); // 숫자 뒤의 남은 공백 제거

    Board board = this.boardList.get(index); //형변환

    if (board == null) {
      System.out.println("게시글 인덱스가 유효하지 않습니다. ");
      return;
    }

    System.out.printf("번호: %d\n", board.getNo());
    System.out.printf("제목: %s\n", board.getTitle());
    System.out.printf("등록일: %s\n", board.getDate());
    System.out.printf("조회수: %d\n", board.getViewCount());    
  }

  public void updateBoard() {
    System.out.println("게시글 인덱스? ");
    int index = input.nextInt();
    input.nextLine(); 

    Board oldBoard = this.boardList.get(index); //형변환

    if (oldBoard == null) {
      System.out.println("게시글 인덱스가 유효하지 않습니다. ");
      return;
    }
    System.out.printf("내용 (%s)?",oldBoard.getTitle());
    String title = (input.nextLine());

    if (title.length() == 0 ) {
      System.out.println("게시글 변경을 취소했습니다.");
      return;
    }
    Board newBoard = new Board(); // 새 게시물을 저장할 보드객체
    newBoard.setNo(oldBoard.getNo());
    newBoard.setViewCount(oldBoard.getViewCount());
    newBoard.setTitle(title); // 새로운 내용으로 저장
    newBoard.setDate(new Date(System.currentTimeMillis())); // 현재시간으로 변경

    this.boardList.set(index, newBoard); // 지정된 위치에 새 게시물로 변경
    System.out.println("게시글을 변경했습니다.");
  }
  
  public void deleteBoard() {
    System.out.println("게시글 인덱스? ");
    int index = input.nextInt();
    input.nextLine(); // 숫자 뒤의 남은 공백 제거

    Board board = this.boardList.get(index); //형변환

    if (board == null) {
      System.out.println("게시글 인덱스가 유효하지 않습니다. ");
      return;
    }
    this.boardList.remove(index);
    System.out.println("게시글을 삭제했습니다.");
  }

  
}
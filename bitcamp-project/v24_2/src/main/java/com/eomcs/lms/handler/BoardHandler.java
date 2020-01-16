// listBoard() 메서드 변경
// => toArray()의 리턴 값을 사용하는 대신 iterator()의 리턴값을 사용하여 목록 출력.

package com.eomcs.lms.handler;

import java.sql.Date;
import com.eomcs.lms.domain.Board;
import com.eomcs.util.Iterator;
import com.eomcs.util.List;
import com.eomcs.util.Prompt;

public class BoardHandler {

  List<Board> boardList;

  Prompt prompt;

  public BoardHandler(Prompt prompt, List<Board> list) {
    this.prompt = prompt;
    this.boardList = list;
  }

  public void listBoard() {
    
 // 목록에서 값을 꺼내는 일을 해 줄 Iterator 객체를 준비한다.
  Iterator<Board> iterator = boardList.iterator();
  
//Iterator 객첼르 통해 값을 꺼낸다.
  while (iterator.hasNext()) {
    Board b = iterator.next();
    System.out.printf("%d, %s, %s, %d\n", 
        b.getNo(), b.getTitle(), b.getDate(), b.getViewCount());
  }
}

public void addBoard() {
  Board board = new Board();

  board.setNo(prompt.inputInt("번호? "));
  board.setTitle(prompt.inputString("내용? "));
  board.setDate(new Date(System.currentTimeMillis()));
  board.setViewCount(0);

  this.boardList.add(board);

  System.out.println("저장하였습니다.");
}

public void detailBoard() {
  int index = indexOfBoard(prompt.inputInt("번호? "));

  if (index == -1) {
    System.out.println("해당 번호의 게시글이 없습니다.");
    return;
  }

  Board board = this.boardList.get(index);
  System.out.printf("번호: %d\n", board.getNo());
  System.out.printf("제목: %s\n", board.getTitle());
  System.out.printf("등록일: %s\n", board.getDate());
  System.out.printf("조회수: %d\n", board.getViewCount());
}

public void updateBoard() {
  int index = indexOfBoard(prompt.inputInt("번호? "));

  if (index == -1) {
    System.out.println("해당 번호의 게시글이 없습니다.");
    return;
  }

  Board oldBoard = this.boardList.get(index);
  Board newBoard = new Board();

  newBoard.setNo(oldBoard.getNo());
  newBoard.setViewCount(oldBoard.getViewCount());
  newBoard.setDate(new Date(System.currentTimeMillis()));
  newBoard.setTitle(prompt.inputString(
      String.format("내용(%s)? ", oldBoard.getTitle()), 
      oldBoard.getTitle()));


  if (newBoard.equals(oldBoard)) {
    System.out.println("게시글 변경을 취소했습니다.");
    return;
  }

  this.boardList.set(index, newBoard);
  System.out.println("게시글을 변경했습니다.");
}

public void deleteBoard() {
  int index = indexOfBoard(prompt.inputInt("번호? "));

  if (index == -1) {
    System.out.println("해당 번호의 게시글이 없습니다.");
    return;
  }

  this.boardList.remove(index);

  System.out.println("게시글을 삭제했습니다.");
}

private int indexOfBoard(int no) {
  for (int i = 0; i < this.boardList.size(); i++) {
    if (this.boardList.get(i).getNo() == no) {
      return i;
    }
  }
  return -1;
}

}
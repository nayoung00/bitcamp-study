// listBoard() 메서드 변경
// => toArray()의 리턴 값을 사용하는 대신 iterator()의 리턴값을 사용하여 목록 출력.

package com.eomcs.lms.handler;

import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.util.Prompt;

public class BoardUpdateCommand implements Command {

  Prompt prompt;
  BoardDao boardDao;

  public BoardUpdateCommand(BoardDao boardDao, Prompt prompt) {
    this.boardDao = boardDao;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    try {
      int no = prompt.inputInt("번호? ");

      Board oldBoard = null;
      try {
        oldBoard = boardDao.findByNo(no);
      } catch (Exception e) {
        System.out.println("해당 번호의 게시글이 없습니디!");
        return;
      }

      Board newBoard = new Board();
      newBoard.setNo(oldBoard.getNo());
      newBoard.setTitle(
          prompt.inputString(String.format("내용(%s)? ", oldBoard.getTitle()), oldBoard.getTitle()));


      if (newBoard.getTitle().equals(oldBoard.getTitle())) {
        System.out.println("게시글 변경을 취소했습니다.");
        return;
      }
      boardDao.update(newBoard);
      System.out.println("게시글을 변경했습니다.");

    } catch (Exception e) {
      System.out.println("변경 실패!");
    }
  }
}

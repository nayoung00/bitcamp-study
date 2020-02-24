package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.domain.PhotoBoard;

public class PhotoBoardDetailServlet implements Servlet {

  PhotoBoardDao photoBoardDao;

  public PhotoBoardDetailServlet(PhotoBoardDao photoBoardDao) {
    this.photoBoardDao = photoBoardDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    out.println("사진 게시글 번호? \n!{}!");
    out.flush();
    int no = Integer.parseInt(in.nextLine());

    PhotoBoard PhotoBoard = photoBoardDao.findByNo(no);

    if (PhotoBoard != null) {
      out.printf("번호: %d\n", PhotoBoard.getNo());
      out.printf("제목: %s\n", PhotoBoard.getTitle());
      out.printf("등록일: %s\n", PhotoBoard.getCreatedDate());
      out.printf("조회수: %d\n", PhotoBoard.getViewCount());
      out.printf("수업: %s\n", PhotoBoard.getLesson().getTitle());
    } else {
      out.println("해당 번호의 사진 게시글이 없습니다.");
    }
  }
}

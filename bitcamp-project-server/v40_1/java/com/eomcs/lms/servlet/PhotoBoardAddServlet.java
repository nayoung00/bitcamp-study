package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.util.Prompt;

public class PhotoBoardAddServlet implements Servlet {

  PhotoBoardDao photoBoardDao;
  LessonDao lessonDao;
  PhotoFileDao photoFileDao;

  public PhotoBoardAddServlet(PhotoBoardDao photoBoardDao, LessonDao lessonDao,
      PhotoFileDao photoFileDao) {
    this.photoBoardDao = photoBoardDao;
    this.lessonDao = lessonDao;
    this.photoFileDao = photoFileDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    PhotoBoard photoBoard = new PhotoBoard();

    photoBoard.setTitle(Prompt.getString(in, out, "제목? "));
    int lessonNo = Prompt.getInt(in, out, "수업 번호? ");

    Lesson lesson = lessonDao.findByNo(lessonNo);
    if (lesson == null) {
      out.println("수업 번호가 유효하지 않습니다.");
      return;
    }

    photoBoard.setLesson(lesson);

    try {
      if (photoBoardDao.insert(photoBoard) == 0) {
        throw new Exception("사진 게시글 등록에 실패 했습니다.");
      }
      List<PhotoFile> photoFiles = inputPhotoFiles(in, out);
      // ArrayList에 들어 있는 PhotoFile 데이터를 lms_photo_file 테이블에 저장한다.
      for (PhotoFile photoFile : photoFiles) {
        photoFile.setBoardNo(photoBoard.getNo());
        photoFileDao.insert(photoFile);
      }
      out.println("새 사진 게시글을 등록 했습니다.");

    } catch (Exception e) {
      out.println(e.getMessage());
    }
  }


  private List<PhotoFile> inputPhotoFiles(Scanner in, PrintStream out) {
    // 첨부 파일을 입력 받는다.
    out.println("최소한 한 개의 사진 파일을 등록해야 합니다.");
    out.println("파일명 입력 없이 그냥 엔터를 치면 파일 추가를 마칩니다.");

    ArrayList<PhotoFile> photoFiles = new ArrayList<>();

    while (true) {
      String filepath = Prompt.getString(in, out, "사진 파일? ");

      if (filepath.length() == 0) {
        if (photoFiles.size() > 0) {
          break;
        } else {
          out.println("최소한 한 개의 사진 파일을 등록해야 합니다.");
          continue;
        }
      }
      // 1) 기본 생성자를 사용할 때,
      // PhotoFile photoFile = new PhotoFile();
      // photoFile.setFilepath(filepath);
      // photoFile.setBoardNo(photoBoard.getNo());
      // photoFiles.add(photoFile);

      // 2) 초기 값을 생성하는 생성자를 사용할 때,
      // photoFiles.add(new PhotoFile(filepath, photoBoard.getNo()));

      // 3) 셋터 메서드를 활용하여 체인 방식으로 인스턴스 필드의 값을 설정.
      photoFiles.add(new PhotoFile().setFilepath(filepath));
    }
    return photoFiles;
  }
}

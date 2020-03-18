package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.lms.service.PhotoBoardService;
import com.eomcs.util.Component;
import com.eomcs.util.Prompt;
import com.eomcs.util.RequestMapping;

@Component
public class PhotoBoardUpdateServlet {

  PhotoBoardService photoBoardService;

  public PhotoBoardUpdateServlet(PhotoBoardService photoBoardService) {

    this.photoBoardService = photoBoardService;
  }

  @RequestMapping("/photoboard/update")
  public void service(Scanner in, PrintStream out) throws Exception {

    int no = Prompt.getInt(in, out, "번호? ");

    PhotoBoard old = photoBoardService.get(no);
    if (old == null) {
      out.println("해당 번호의 사진 게시글이 없습니다.");
      return;
    }

    PhotoBoard photoBoard = new PhotoBoard();
    photoBoard.setNo(no);
    photoBoard.setTitle(
        Prompt.getString(in, out, String.format("제목(%s)? ", old.getTitle(), old.getTitle())));

    printPhotoFiles(out, old);
    out.println();
    out.println("사진은 일부만 변경할 수 없습니다.");
    out.println("전체를 새로 등록해야 합니다.");

    String response = Prompt.getString(in, out, "사진을 변경하시겠습니까?(y/n) ");

    if (response.equalsIgnoreCase("y")) {
      // 이 사진 게시글에 첨부되었던 기존 파일을 모두 삭제한다.
      photoBoard.setFiles(inputPhotoFiles(in, out));
    }

    photoBoardService.update(photoBoard);
    out.println("사진게시물을 변경했습니다.");

    List<PhotoFile> photoFiles = inputPhotoFiles(in, out);

  }

  private void printPhotoFiles(PrintStream out, PhotoBoard photoBoard) throws Exception {
    out.println("사진 파일: ");
    List<PhotoFile> oldPhotoFiles = photoBoard.getFiles();
    for (PhotoFile photoFile : oldPhotoFiles) {
      out.printf("> %s\n", photoFile.getFilepath());
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
      photoFiles.add(new PhotoFile().setFilepath(filepath));
    }
    return photoFiles;
  }
}

package com.eomcs.lms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.service.BoardService;
import com.eomcs.util.RequestMapping;

@Component
public class BoardDetailController {

  @Autowired
  BoardService boardService;

  @RequestMapping("/board/detail")
  public String detail(HttpServletRequest request, HttpServletResponse response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));
    Board board = boardService.get(no);

    // JSP가 출력할 때 사용할 수 있도록
    // 조회 결과를 ServletRequest 보관소에 담는다.
    request.setAttribute("board", board);
    return "/board/detail.jsp";
  }
}

// "/board/list" 명령어 처리

package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.eomcs.lms.dao.BoardDao;

public class BoardListCommand implements Command {

  BoardDao boardDao;

  public BoardListCommand(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void execute() {
    try {
      // List<Board> boards = boardDao.findAll();

      // JDBC Driver(MariaDB 프록시)를 로딩한다.
      Class.forName("org.mariadb.jdbc.Driver");

      // JDBC Driver를 이용하여 MariaDB에 접속한다.
      Connection con =
          DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");

      // MariaDB에 명령을 전달할 객체 준비
      Statement stmt = con.createStatement();

      // MariaDB
      ResultSet rs = stmt.executeQuery("select board_id, conts, cdt, vw_cnt from lms_board");

      while (rs.next()) {
        System.out.printf("%d, %s, %s, %d\n", rs.getInt("board_id"), rs.getString("conts"),
            rs.getDate("cdt"), rs.getInt("vw_cnt"));
      }
      rs.close();
      stmt.close();
      con.close();
    } catch (Exception e) {
      System.out.println("목록 조회 실패!");
    }
  }
}

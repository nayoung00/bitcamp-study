package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberListServlet implements Servlet {

  MemberDao memberDao;

  public MemberListServlet(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    List<Member> members = memberDao.findAll();
    for (Member member : members) {
      out.printf("%d, %s, %s, %s, %s, %s, %s\n", member.getNo(), member.getName(),
          member.getEmail(), member.getPassword(), member.getRegisteredDate(), member.getTel(),
          member.getPhoto());
    }
  }
}

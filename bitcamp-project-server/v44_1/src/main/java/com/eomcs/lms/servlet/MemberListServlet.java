package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

public class MemberListServlet implements Servlet {

  MemberService memberService;

  public MemberListServlet(MemberService memberService) {
    this.memberService = memberService;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    List<Member> members = memberService.list();
    for (Member member : members) {
      out.printf("%d, %s, %s, %s, %s, %s, %s\n", member.getNo(), member.getName(),
          member.getEmail(), member.getPassword(), member.getRegisteredDate(), member.getTel(),
          member.getPhoto());
    }
  }
}

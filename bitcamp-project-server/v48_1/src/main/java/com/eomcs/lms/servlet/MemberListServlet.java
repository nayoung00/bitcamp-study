package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;
import com.eomcs.util.Component;
import com.eomcs.util.RequestMapping;

@Component
public class MemberListServlet {

  MemberService memberService;

  public MemberListServlet(MemberService memberService) {
    this.memberService = memberService;
  }

  @RequestMapping("/member/list")
  public void service(Scanner in, PrintStream out) throws Exception {
    List<Member> members = memberService.list();
    for (Member member : members) {
      out.printf("%d, %s, %s, %s, %s, %s, %s\n", member.getNo(), member.getName(),
          member.getEmail(), member.getPassword(), member.getRegisteredDate(), member.getTel(),
          member.getPhoto());
    }
  }
}

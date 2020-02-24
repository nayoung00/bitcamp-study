package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberUpdateServlet implements Servlet {

  MemberDao memberDao;

  public MemberUpdateServlet(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    out.println("번호? \n!{}!");
    out.flush();
    int no = Integer.parseInt(in.nextLine());

    Member old = memberDao.findByNo(no);

    if (old == null) {
      out.println("해당 번호의 회원이 없습니다.");
      return;
    }
    Member member = new Member();
    member.setNo(no);

    out.printf("회원(%s)? \n!{}!\n", old.getName());
    member.setName(in.nextLine());
    out.printf("이메일? \n!{}!\n", old.getEmail());
    member.setEmail(in.nextLine());
    out.printf("암호? \n!{}!\n", old.getPassword());
    member.setPassword(in.nextLine());
    out.printf("사진? \n!{}!\n", old.getPhoto());
    member.setPhoto(in.nextLine());
    out.printf("전화? \n!{}!\n", old.getTel());
    member.setTel(in.nextLine());

    out.flush();

    if (memberDao.update(member) > 0) { // 변경했다면,
      out.println("회원을 변경했습니다.");
    } else {
      out.println("회원 변경에 실패했습니다.");
    }
  }
}


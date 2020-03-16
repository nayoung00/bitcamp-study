package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.util.Component;

@Component("/hello")
public class HelloServlet implements Servlet {

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    out.println("안녕하세요!");
  }
}

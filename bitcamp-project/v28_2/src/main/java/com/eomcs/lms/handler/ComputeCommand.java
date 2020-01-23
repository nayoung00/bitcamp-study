// "/board/detail" 명령 처리

package com.eomcs.lms.handler;

import com.eomcs.util.Prompt;

public class ComputeCommand implements Command {

  Prompt prompt;

  public ComputeCommand(Prompt prompt) {
    this.prompt = prompt;
  }

  @Override
  public void execute() {


    int num1 = prompt.inputInt("수1? ");
    int num2 = prompt.inputInt("수2? ");

    System.out.printf("계산 결과는? %d입니다.\n", num1 + num2);

  }

}

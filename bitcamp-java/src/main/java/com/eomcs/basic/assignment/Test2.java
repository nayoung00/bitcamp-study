// 과제 1 : 가위,바위,보 게임 애플리케이션을 작성하라.
// - 실행1
// 가위,바위,보? 보
// 컴퓨터: 가위  (랜덤 값이 출력된다. 힌트: Math.random())
// => 졌습니다.
//
// - 실행2
// 가위,바위,보? 바위
// 컴퓨터: 가위
// => 이겼습니다.
//

package com.eomcs.basic.assignment;

import java.util.Scanner;

public class Test2 {
  public static void main(String[] args) {
    // 사용자로부터 입력 받기 
    Scanner keyScan = new Scanner(System.in);  

    System.out.println("가위,바위,보?");
    String response = keyScan.nextLine();
    System.out.printf("사용자: %s\n", response);

    int random = ((int)(Math.random()*3));
    String computer;
    if(random == 0)
      computer = "가위";
    else if (random == 1)
      computer = "바위";
    else 
      computer = "보";

    System.out.printf("컴퓨터:%s\n", computer);
  }

}
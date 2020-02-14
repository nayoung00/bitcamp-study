// 스레드 재사용 - 3단계) sleep()/timeout 을 활용한 스레드 재사용 II

package com.eomcs.concurrent.ex6;

import java.util.Scanner;

public class Exam0130 {

  public static void main(String[] args) {

    class MyThread extends Thread {
      boolean enalbe;
      int count;

      public void setCount(int count) {
        this.count = count;

        // 카운트를 설정하면 스레드의 작업을 허락하게 하자!
        this.enalbe = true;
      }

      @Override
      public void run() {
        System.out.println("스레드 시작했음! ");
        try {
          // 스레드를 재사용하려면 다음과 같이 run() 메서드가 종료되지 않게 해야 한다.
          while (true) {
            System.out.println("스레드를 10초 동안 잠들게 한다.");
            Thread.sleep(10000);

            // 무조건 작업하지 말고,
            // enalbe이 true일 때만 작업하게 하자!
            if (!enalbe) {
              continue;
            }

            System.out.println("카운트 시작! ");
            for (int i = count; i > 0; i--) {
              System.out.println("==> " + i);
              Thread.sleep(1000);
            }
            // 스레드에게 맡겨진 작업이 끝나면 비활성 상태로 설정한 후
            // 10초 동안 잠든다.
            enalbe = false;
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
    MyThread t = new MyThread();
    t.start();

    Scanner keyScan = new Scanner(System.in);

    while (true) {
      System.out.print("카운트? ");
      String str = keyScan.nextLine();
      if (str.equals("quit")) {
        break;
      }

      int count = Integer.parseInt(str);
      t.setCount(count);
      // 이 버전은 다음과 같이 동작한다.
      // => 스레드가 작업을 완료하면 10초 동안 잠든다.
      // => 10초 후에 깨어났을 때 카운트 값이 설정되어 있지 않으면
      // => 다시 잠든다.
      // => 카운트 값이 설정되면서 enable이 활성화 상태라면 작업을 실행한다.
      // => 작업이 끝나면 enalbe을 비활성으로 만든 후 잠든다.
      // 이전 버전에서는 깨어난 후 무조건 작업을 수행했지만,
      // 이 버전은 카운트 값이 설정될 때만 작업하도록 개선하였다.
      // 그러나 근본적인 문제는 해결되지 않았다.
      // => 작업을 완료한 후 무조건 10초를 기다린다.
      // => 스레드가 깨어난 후 작업이 없더라도 10초를 기다린다.
      //

    }
    System.out.println("main 스레드 종료!");
    keyScan.close();
  }
}


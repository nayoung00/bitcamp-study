//* 파라미터로 배열을 받고, 그 값 중에서 최대 값을 찾아 리턴한다.
package com.eomcs.basic.ex07.text.assignment;

public class Test012 {

  public static void main(String[] args) {
    int[] values = {34, 4, -3, 78, 12, 22, 45, 0, -22};

    int value = max(values); // 매서드 호출

    System.out.println(values);
    // 출력결과:
    // 78
  }

  static int max(int[] values) {
    // 파라미터로 배열을 받고, 그 값 중에서 최대 값을 찾아 리턴한다.
    int maxValue = values[0]; 
    for (int i = 1; i<values.length; i++) {
      if (values[i] > maxValue) {
        maxValue = values[i];
      }

    }
    return maxValue;
  }
}
//* 파라미터로 배열을 받고, 그 값 중에서 최대 값을 찾아 리턴한다.
package com.eomcs.basic.ex07.assignment;

public class Test01 {

  public static void main(String[] args) {
    int[] values = {34, 4, -3, 78, 12, 22, 45, 0, -22};
    System.out.printf("Result:%d\n" ,max(values));
  }
  public static int max(int[] values) {
    int minimun = Integer.MIN_VALUE;
    for (int tmp:values) {
      if(tmp>minimun)
        minimun=tmp;
    }
    return minimun;
  }
}
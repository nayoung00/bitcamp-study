package com.eomcs.basic.ex07.text.assignment;

public class Test02 {

  public static void main(String[] args) {
     int [] values = {34, 4, -3, 78, 12, 22, 45, 0, -22};
     // 배열에 들어 있는 값을 오름차순으로 정렬을 수행. 
    
     sort(values);
    for (int value : values) {
      System.out.println(value);
    }
    // 출력결과:
    // - 22, 23, 0, 4, 12, 22, 34, 45, 78
  }

}

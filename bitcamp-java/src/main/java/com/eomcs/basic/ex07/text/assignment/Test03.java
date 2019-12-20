package com.eomcs.basic.ex07.text.assignment;

public class Test03 {

  public static void main(String[] args) {
    int [] values = {34, 4, -3, 78, 12, 22, 45, 0, -22};
    
    // 배열의 들어 있는 값의 순서를 거꾸로 바꾸라. 
    reverse(values); //오름차순으로 정렬을 수행. 
    
    for (int value : values) {
      System.out.println(value);
    }
    // 출력결과:
    // -22, 0, 45, 22, 12, 78, -3, 4, 34 
  }

}

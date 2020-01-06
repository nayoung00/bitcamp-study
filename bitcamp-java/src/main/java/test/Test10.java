package test;

public class Test10 {
  public static void main(String[] args) {

    for(int i = 0; i < 9; i++) {
      for(int j = 0; j < 9; j++) {
        if(j > 5)
          continue;  // 반복문의 조건식으로 간다.
        System.out.printf("%d : %d\n", i, j);
      }
    }
  }
}


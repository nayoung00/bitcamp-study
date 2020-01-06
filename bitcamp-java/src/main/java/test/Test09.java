package test;

public class Test09 {
  public static void main(String[] args) {

    for(int i = 0; i < 9; i++) {
      for(int j = 0; j < 9; j++) {
        System.out.printf("%d : %d\n", i, j);
        if(j > 5)
          break;
      }
    }
  }
}


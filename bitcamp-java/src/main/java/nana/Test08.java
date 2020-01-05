package nana;

public class Test08 {
  public static void main(String[] args) {

    int x = 1;
    while (x <= 10) {
      System.out.println(x);
      if(x>5)
        break; // break문은 가장 가까운 반복문을 탈출한다.
      x++;
    }
  }
}


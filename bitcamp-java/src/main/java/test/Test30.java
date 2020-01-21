package test;

public class Test30 {
  public static void main(String[] args) {
    int marks[] = {90, 75, 80, 85, 100};

    for (int i = 0; i < marks.length; i++) {
      if (marks[i] > 80) {
        System.out.println((i + 1) + "번 합격");
      } else {
        System.out.println((i + 1) + "번 불합격");
      }
    }
  }
}



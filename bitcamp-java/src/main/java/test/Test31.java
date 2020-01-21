package test;

public class Test31 {
  public static void main(String[] args) {
    int[] marks = {50, 75, 45, 60, 80};

    for (int i = 0; i < marks.length; i++) {
      if (marks[i] < 60) {
        continue;
      }
      System.out.println((i + 1) + "합격입니다.");
    }
  }
}

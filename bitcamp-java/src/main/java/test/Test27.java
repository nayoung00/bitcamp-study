package test;

public class Test27 {
  public static void main(String[] args) {

    int treeHit = 0;
    while (treeHit < 10) {
      treeHit++;
      System.out.println("나무를 " + treeHit + " 번 찍었습니다.");
      if (treeHit == 10) {
        System.out.println("나무가 넘어갔습니다.");
      }
    }
  }
}

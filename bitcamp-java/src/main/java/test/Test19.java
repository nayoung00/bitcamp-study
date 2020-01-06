package test;

public class Test19 {
  public static void main(String[] args) {
    MyMath2<Integer> m = new MyMath2<>(1, 2);
    MyMath2<String> m2 = new MyMath2<>("AAA", "ABC");
    System.out.println(m.getNum());
    System.out.println(m2.getNum());
  }
}

class MyMath2 <T> {
  T num1;
  T num2;
  public MyMath2 (T num1, T num2) {
    this.num1 = num1;
    this.num2 = num2;
  }
  public T getNum() {
    return this.num1;

  }
}

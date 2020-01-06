package test;

public class Test18 {
  public static void main(String[] args) {

    MyMath.add(1, 2);
    
  }
}

class MyMath {
  public static void add (int a, int b) {
    System.out.println(a + b);
  }
  
  public static void add(double a, double b) {
    System.out.println(a + b);
  }
}
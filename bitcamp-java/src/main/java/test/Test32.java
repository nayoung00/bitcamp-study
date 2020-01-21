package test;

public class Test32 {

  public void update(int count) {
    count++;
  }
}


public class Counter2 {
  int count = 0;

  public static void main(String[] args) {
    Counter2 myCounter = new Counter2();
    System.out.println("before update:" + myCounter.count);
    myUpdater.update(myCounter.count);
    System.out.println("after update:" + myCounter.count);

  }

}



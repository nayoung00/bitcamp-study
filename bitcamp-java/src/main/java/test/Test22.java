package test;

import java.util.concurrent.ArrayBlockingQueue;

public class Test22 {

  public static void main(String[] args) {
    String s1 = new String("aaa");
    String s2 = new String("bbb");
    String s3 = new String("ccc");
    String s4 = new String("ddd");
    String s5 = new String("eee");

    ArrayBlockingQueue queue = new ArrayBlockingQueue(100);
    queue.offer(s1);
    print(queue);
    queue.offer(s2);
    print(queue);
    queue.offer(s3);
    print(queue);

    System.out.println("==>" + queue.poll());
    print(queue);
    System.out.println("==>" + queue.poll());
    print(queue);

    queue.offer(s4);
    print(queue);
    queue.offer(s5);
    print(queue);

    String value;
    while ((value = (String) queue.poll()) != null) {
      System.out.println(value);
    }
  }

  private static void print(ArrayBlockingQueue list) {
    Object[] arr = list.toArray();
    for (Object value : arr) {
      System.out.println(value + ", ");
    }
    System.out.println();
  }
}

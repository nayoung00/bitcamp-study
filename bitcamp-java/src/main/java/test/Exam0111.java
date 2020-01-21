// 제네릭(Generic) - 사용 전: 다형적 변수 활용
package test;

import com.eomcs.generic.ex01.Member;

public class Exam0111 {

  static class ObjectBox {
    Object value;

    public void set(Object value) {
      this.value = value;
    }

    public Object get() {
      return value;
    }
  }

  public static void main(String[] args) {

    ObjectBox box1 = new ObjectBox();
    box1.set(new Member("홍길동", 20));
    Member m = (Member) box1.get();
    System.out.println(m);

    ObjectBox box2 = new ObjectBox();
    box2.set(new String("Hello"));
    String str = (String) box2.get();
    System.out.println(str);

    ObjectBox box3 = new ObjectBox();
    box3.set(180);
    int i = (int) box3.get();

    System.out.println(i);
  }

}


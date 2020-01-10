// 제네릭(Generic) - 사용 전 
package com.eomcs.generic.ex01;

public class Exam0111 {

  // 다양한 객체를 저장하는 Box를  만들기 위해
  // 인스턴스 변수 타입을 Object로 선언한다.
  // => 그러면 다음과 같이 한 개의 Box 타입만 선언하면 된다.
  static class  ObjectBox {
    Object value;

    public void set(Object value) {
      this.value = value;
    }

    public Member get() {
      return value;
    }
  }
  public static void main(String[] args) {
    ObjectBox box1 = new ObjectBox();
    box1.set(new Member("홍길동", 20) );
    Member m = (Member) box1.get();
    System.out.println(m);


    ObjectBox box2 = new ObjectBox();
    box2.set(new String("홍길동", 20) );
    String str = (String) box2.get();
    System.out.println(str);


    System.out.println(i);

    // 객체의 타입 별로 Box 클래스를 구분해서 쓰지 않으니 코딩이 편하다.
    // 단 값을 꺼낼 때 원래의 타입으로 바꾸기 위해 형변환(type casting)해야 하는 불편함이 있다.
    // 
    // Object 레퍼런스의 치명적 단점:
    // => 의도와 다른 타입의 값을 저장하는 것을 막을 수 없다.
  }

}



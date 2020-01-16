package com.eomcs.util;
import java.util.Arrays;

public class Stack<E> implements Cloneable{

  private static final int DEFAULT_CAPACITY = 10;

  Object[] elementData;
  int size;

  public Stack() {
    this.elementData = new Object[DEFAULT_CAPACITY];
    this.size = 0;
  }

  public void push(E value) {
    if (this.size == elementData.length) {
      grow();
    }
    this.elementData[size++] = value;
  }

  private void grow() {
    this.elementData = Arrays.copyOf(elementData, newCapacity());
  }

  private int newCapacity() {
    int oldCapacity = elementData.length;
    return oldCapacity + (oldCapacity >> 1);
  }

  @SuppressWarnings("unchecked")
  public E pop() {  
    if (this.empty()) {
      return null;
    }    
    E value = (E) this.elementData[--this.size];
    this.elementData[this.size] = null;
    return value;  
  }

  public boolean empty() {
    return this.size == 0;
  }



  @SuppressWarnings("unchecked")
  @Override
  public Stack<E> clone() {
    try {
      // 1)'shallow copy'를 통해 이 객체의 인스턴스 변수는 그대로 복제한다.
      Stack<E> temp = (Stack<E>) super.clone(); 

      // 2) elementData 배열을 복제한다.
      //  => 배열만 복제하고 그 배열에 저장된 객체(ex: 문자열, Member 등)까지는 복제하지 않는다.
      //  => 어디까지 복제(deep copy의 수준)할 것인지는  상황에 따라 결정한다.
      // 
      Object[] arr = new Object[this.size];
      for (int i = 0; i < this.size; i++ ) {
        arr[i] = this.elementData[i];
      }
      // 3) 복제한 스택 개체가 새로 만든 배열을 가리키도록 한다.
      temp.elementData = arr;
      return temp;

    } catch (CloneNotSupportedException ex) {
      System.out.println(ex);
      return null;
    }
  }



  public Iterator<E> iterator() {
    // anonymous class : 인스턴스를 한 개만 생성한다면 로컬 클래스를 익명 클래스로 정의하라.
    return new Iterator<E>(){

      Stack<E> stack = (Stack<E>) Stack.this.clone();

      @Override
      public boolean hasNext() {
        return !stack.empty(); // 스택 너 비었냐. 
      }

      @Override
      public E next() {
        return stack.pop(); 
      }
    };
  }

  /*
  static void m1() {
    // 스태틱 메서드는 다음과 같이 클래스 이름으로 바로 호출할 수 있기 때문에 this 변수가 없다.
    // 예) stack.m1();


    // 스태틱 메서드에서 로컬 클래스를 정의한다면,
    // 그 로컬 클래스는 바깥 클래스의 인스턴스를 직접 접근할 수 없다. 
   
    class A { 
      A() {
        Stack s;
        s = Stack.this; // 컴파일 오류!
        // 이 로컬 클래스는 m1() 에서 사용할 것이다.
        // m1()은 바깥 클래스의 인스턴스 주소를 모른다. 
        // 그런데 로컬 클래스에서 위와 같이 바깥 클래스의 인스턴스를 사용하려 한다면 
        // 문제가 될 것이다. 
        // 이런 상황을 방지하고자 자바는 컴파일 오류를 발생시킨다. 
      }
}
}    
    */
  

}


package com.eomcs.util;

//Stack 객체에서 Iterator 규칙에 따라 값을 꺼내주는 클래스를 정의
public class StackIterator<E> implements Iterator <E>{

  Stack<E> stack;

  public StackIterator(Stack<E> stack) {
    this.stack = stack.clone(); // 스택을 복제해서 저장. 꺼내는 순간 제거되기 때문.
  }

  @Override
  public boolean hasNext() {
    return !stack.empty(); // 스택 너 비었냐. 
  }


  @Override
  public E next() {
    return stack.pop(); 
  }
}



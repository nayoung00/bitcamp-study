package com.eomcs.lms.handler;

import java.util.Arrays;

public class ArrayList {
 
  static final int DEFAULT_CAPACITY = 3;

  Object[] list; // board 계열의 객체를 저장할 수 있다.
  int size = 0;

  public ArrayList() {
    this.list = new Object[DEFAULT_CAPACITY];
  }

  public ArrayList(int capacity) {
    if (capacity < DEFAULT_CAPACITY || capacity > 10000)
      this.list = new Object[DEFAULT_CAPACITY];
    else
      this.list = new Object[capacity];
  }

  public Object[] toArray() {
    return Arrays.copyOf(this.list, this.size); // 배열을 주고 몇개를 복사할지 선언 .
  }

  public void add(Object obj) {
    if (this.size == this.list.length) {
      // 현재 배열에 게시글 객체가 꽉 찼으면, 배열을 늘린다.
      int oldCapacity = this.list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);

      Object[] arr = new Object[newCapacity];
      for(int i = 0; i < this.list.length; i++) {
        arr[i] = this.list[i];
      }
      this.list = arr;

      this.list = Arrays.copyOf(this.list, newCapacity);
      System.out.printf("새 배열을 %d개 생성하였음! ", newCapacity);
    }
    this.list[this.size++] = obj;
  }

  public Object get(int idx) {
    if(idx >= 0 && idx < this.size) {
      return this.list[idx];
    } else {
      return null;   
    }
  }
}

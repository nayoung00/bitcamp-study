package com.eomcs.util;

import java.util.Arrays;

public class ArrayList<E> {
 
  static final int DEFAULT_CAPACITY = 3;

  Object[] list; 
  int size = 0; // new array 했을때 만들어지는 메모리 설계도

  public ArrayList() {
    this.list = new Object[DEFAULT_CAPACITY];
  }

  public ArrayList(int capacity) {
    if (capacity < DEFAULT_CAPACITY || capacity > 10000)
      this.list = new Object[DEFAULT_CAPACITY];
    else
      this.list = new Object[capacity];
  }
  
  @SuppressWarnings({"unchecked"})
  public E[] toArray(E[] arr) {
    
    if (arr.length < this.size) {
      return (E[])Arrays.copyOf(this.list, this.size, arr.getClass());
    }
    System.arraycopy(this.list, 0, arr, 00, this.size);
       
   /*
    // 위의 arraycopy()는 다음 코드와 같다.
    for ( int i = 0; i < this.size; i++) {
      arr[i] = (E) this.list[i];
    }
    */
    return arr; // 배열이 이 크기의 값을 충분히 복사 할 수 있는 배열이라면 복한다음에 파라미터로 받은 배열을 리턴한다.
        
    // copyOf() 메서드야 ,
    // arrayType 에 지정된 배열을 size 만큼 만들어라.
    // 그리고 list 배열에 저장된 주소를 새로 만든 배열에 복사하라.
    // 마지막으로 새로 만든 배열의 주소를 리턴하라!

    // return (E[]) Arrays.copyOf(this.list, this.size, arrayType );
  }

  public void add(E obj) { 
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

  @SuppressWarnings("unchecked")
  public E get(int idx) {
    if(idx >= 0 && idx < this.size) {
      return (E)this.list[idx];
    } else {
      return null;   
    }
  }
  public int size() {
    return this.size;
  }
}

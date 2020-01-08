package com.eomcs.util;

import java.util.Arrays;

public class ArrayList3 {

  private static final int DEFAULT_CAPACITY = 10;
  Object[] elementData;
  int size;

  public ArrayList3() {
    this.elementData = new Object[DEFAULT_CAPACITY];
  }

  public ArrayList3 (int initialCapacity) {
    if (initialCapacity < DEFAULT_CAPACITY) {
      this.elementData = new Object[DEFAULT_CAPACITY];
    } else {
      this.elementData = new Object[initialCapacity];
    }
  }
  public void add(Object e) {
    if(this.size == this.elementData.length){
      int oldSize = this.elementData.length;
      int newSize = oldSize + (oldSize << 1);
      
      this.elementData = Arrays.copyOf(this.elementData, newSize);
    }
    this.elementData[this.size++] = e;
  }
}

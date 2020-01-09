package com.eomcs.util;

import java.lang.reflect.Array;

public class LinkedList<E> {

  Node<E> first;
  Node<E> last;
  int size;

  public void add(E value) {
    Node<E> newNode = new Node<>();
    newNode.value = value;

    if (first == null) {
      last = first = newNode;
    } else {
      last.next = newNode;
      last = newNode;
    }

    this.size++;
  }

  public E get(int index) {
    if (index < 0 || index >= size)
      return null;

    Node<E> cursor = first;
    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }

    return cursor.value;
  }

  public void add(int index, E value) {
    if (index < 0 || index >= size)
      return;

    Node<E> newNode = new Node<>();
    newNode.value = value;

    Node<E> cursor = first;
    for (int i = 0; i < index - 1; i++) {
      cursor = cursor.next;
    }

    if (index == 0) { // 0번 삽입할때.
      newNode.next = first;
      first = newNode;      
    } else {
      newNode.next = cursor.next;
      cursor.next = newNode;
    }
    this.size++;
  }

  public E remove(int index) {
    if (index < 0 || index >= size)
      return null;

    Node<E> cursor = first;
    for (int i = 0; i < index -1; i++) {
      cursor = cursor.next;
    }
    Node<E> deletedNode = null;
    if(index == 0 ) {
      deletedNode = first;
      first = deletedNode.next;
    }else {
      deletedNode = cursor.next; 
      cursor.next = deletedNode.next; // 현재 커서의 넥스트 값을 넥스트 노드 다음 노드의 주소로 바꾼다. 
    }
    deletedNode.next = null; // 가비지 청소를 깔끔하게...
    size--;

    return deletedNode.value;
  }

  public E set(int index, E value) {
    if (index < 0 || index >= size)
      return null;

    Node<E> cursor = first;
    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }

    E oldvalue = cursor.value;
    cursor.value = value;

    return oldvalue;
  }

  public Object[] toArray() { 
    Object[] arr = new Object[size];

    Node<E> cursor = first;
    for (int i = 0; i < size; i++) {
      arr[i] = cursor.value;
      cursor = cursor.next;
    }
    return arr;
  }

  @SuppressWarnings("unchecked")
  public E[] toArray(E[] arr) { 

    if (arr.length < size) {
      arr =(E[]) Array.newInstance(arr.getClass().getComponentType(), size); // 배열의 한 항목 타입,   
    }
    
    Node<E> cursor = first;
    for (int i = 0; i < size; i++) {
      arr[i] = cursor.value;
      cursor = cursor.next;
    }
    return arr;
  }
  
  public int size() {
    return this.size;
  }

  static class Node<T> {
    T value;
    Node<T> next;
  }
}
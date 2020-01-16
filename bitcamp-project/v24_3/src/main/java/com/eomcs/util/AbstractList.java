package com.eomcs.util;

public abstract class AbstractList<E> implements List<E> {

  protected int size;

  public int size() {
    return size;
  }
  
  @Override
  public Iterator<E> iterator() {
    return this.new ListIterator<E>();  //static 인 경우는 this.붙이면 오류 /
    // inner클래스의 객체를 만들기위해서는 반드시 밖 클래스에 주소가 있어야 한다. 안붙인게 아니라 생략하는거임.
  }
  
  
   // non-static nested class = inner class 
   class ListIterator<T> implements Iterator<T>() {

    List<T> list;
    int cursor;

    @SuppressWarnings("unchecked")
    public ListIterator() {
      this.list = (List <T>) AbstractList.this;
    }

    @Override
    public boolean hasNext() {
      return cursor < list.size();
    }

    
    @Override
    public T next() {
      return list.get(cursor++);
    }
  }

}


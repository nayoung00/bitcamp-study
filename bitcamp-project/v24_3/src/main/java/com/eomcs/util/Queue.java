package com.eomcs.util;

public class Queue<E> extends LinkedList<E> implements Cloneable { //상속 먼저 하고 어떤규칙 준수할것인지 설정.

  public void offer(E value) {
    this.add(value);
  }

  public E poll() {
    return this.remove(0);
  }

  /*
  @Override
  public Queue clone(){
    try {
      // 단순히 객체 인스턴스 변수를 복제하는 'shallow copy' 수행 
      // => Object의 clone()은 'shallow copy'를 수행한다.
      // => Queue에서 poll()을 수행하면 first 노드를 삭제하게 되고,
      //    이때 원본 객체의 노드의 링크 정보를 변경하게 된다.
      // => 따라서 다음에 다시 복제를 수행하면,
      //    원본 노드의 링크 정보가 제거되었기 때문에 , 제대로 작업을 수행할 수 없다. 
      //
      // 해결책?
      // => 원본 객체가 사용하는 노드도 함께 복제해야 한다. 
      // => 즉 'deep copy'를 수행해야 한다. 
      // 
      return (Queue) super.clone();

    } catch (CloneNotSupportedException ex) {
      System.out.println(ex);
      return null;
    }
  }


   */
  @Override
  public Queue<E> clone() {
    Queue<E> temp = new Queue<>();
    
    for (int i = 0; i < this.size(); i++) {
      temp.offer(this.get(i));
    }
    return temp;
  }
  
  public Iterator<E> iterator() {
    // this = 인스턴스 주소; 
    // inner class 의 생성자를 호출할때는 바깥 클래스의 인스턴스 주소를 파라미터로 넘기지 말고,
    // 앞에서 넘겨라.
    return this.new QueueIterator<>();
  }
  
  // non-static nested class = inner class 
  class QueueIterator<T> implements Iterator <T>{ //inner클래스의 제네릭은 T

    Queue<T> queue;

    public QueueIterator() {
      this.queue = (Queue<T>) Queue.this.clone(); // 바깥클래스명.this 
    }

    @Override
    public boolean hasNext() {
      return queue.size() > 0; 
    }
    
    @Override
    public T next() {
      return queue.poll(); 
    }
  }
}

/*
## 클래스 멤버:

  class 클래스 {
    필드 선언(스태틱, 인스턴스)
    초기화블록(스태틱, 인스턴스)
    생성자(
    메서드(스태틱, 인스턴스)
    중첩클래스 (스태틱, 인스턴스)
    }
    
 */
 

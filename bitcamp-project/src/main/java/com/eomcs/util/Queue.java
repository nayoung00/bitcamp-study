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
    return new QueueIterator<>(this);
  }
}

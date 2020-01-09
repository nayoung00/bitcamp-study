package test;

public class ArrayList {
  
  private static final int DEFAULT_CAPACITY = 10;
  
  Object[] elementData;
  int size;
  
  public ArrayList() {
    this.elementData = new Object[DEFAULT_CAPACITY];
  }
  
  public ArrayList(int initialCapacity) {
    if (initialCapacity < DEFAULT_CAPACITY) {
      this.elementData = new Object[DEFAULT_CAPACITY];
    } else {
      this.elementData = new Object[initialCapacity];
    }
  }
  
  public void add(Object e) {
    this.elementData[this.size++] = e;
  }
  
  public Object get(int index) {
    return this.elementData[index];
  }
  
  public void set(int index, Object e) {
    this.elementData[index] = e;
  }
  
  public void remove(int index) { // 11번
    
  }
}

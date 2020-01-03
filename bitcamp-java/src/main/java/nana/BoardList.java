package nana;

public class BoardList {
  
  static final int BOARD_SIZE = 100;

  Board[] list;
  int size = 0;

  public BoardList() {
    this.list = new Board[BOARD_SIZE];    
  }
  public BoardList(int capacity) {
    if (capacity < BOARD_SIZE || capacity > 10000)
      this.list = new Board[BOARD_SIZE];
    else
      this.list = new Board[capacity];
  }
  public Board[] toArray(){
    Board[] arr = new Board[this.size];
    for (int i = 0; i < this.size; i++) {
      Board b = this.list[i];
    }
    return arr;
  }
  public Board get(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.list[i].getNo() == no) {
        return this.list[i];
      }
    }
    return null;
  }
  public void add(Board board) {
    list[size++] = board;
  }
}

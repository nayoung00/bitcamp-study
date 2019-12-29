package nana;

public class m02 {


  public static void main(String[] args) {
    LotteryGameHandler handler = new LotteryGameHandler();
    handler.makeGameSet();
    System.out.println(handler);      
  }
}
class LotteryGameHandler {
  private final int SIZE;
  private int[] gameSet;
  public LotteryGameHandler() {
    this.SIZE = 6;
    this.gameSet = new int[SIZE];
  }
  public void makeGameSet() {
    for(int i = 0; i < SIZE; i++) {
      gameSet[i] = makeRandomNumber();
      if(i > 0 && !checkDuplicateNumber(gameSet[i], i))
        i--;
    }
    sortGameSet();
  }
  private int makeRandomNumber() {
    return (int)(Math.random()*45 + 1);
  }
  private boolean checkDuplicateNumber(int generatedNumber, int currIdx) {
    for(int i = 0; i < currIdx; i++) {
      if(gameSet[i] == generatedNumber)
        return false;
    }
    return true;
  }
  private void sortGameSet() {
    for(int i = 0; i < SIZE; i++) {
      int tmpVal = Integer.MAX_VALUE;
      for(int j = i; j < SIZE; j++) {
        if(gameSet[j] < tmpVal) {
          tmpVal = gameSet[j];
          gameSet[j] = gameSet[i];
          gameSet[i] = tmpVal;
        }
      }
    }
  }
  public String toString() {
    String res = "";
    for(int i = 0; i < SIZE; i++) {
      res += gameSet[i] + " ";
    }
    return res;
  }
}
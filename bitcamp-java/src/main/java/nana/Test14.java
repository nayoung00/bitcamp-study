package nana;

public class Test14 {
  public static void main(String[] args) {

    int[][] arr = new int [4][3];
    for(int i = 0; i < arr.length; i++){
      for(int j= 0; j < arr[i].length; j++){
        arr[i][j] = j;
        System.out.printf(arr[i][j]+ " ");
      }
      System.out.println();
    }

  }
}

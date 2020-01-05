package nana;

public class Test13 {
  public static void main(String[] args) {
    //String 배열

    // String 배열 객체의 주소를 담을 수 있는 레퍼런스 변수 선언
    String[] arr;    
    
    // Heap 영역에 String 객체의 주소를 담을 수 있는 공간 5개를 만들고 
    // 해당 공간 전체 (스트링 배열 주소)를 arr에 저장.
    arr = new String[5]; 

    arr[0] = new String("ABCDE");
    
    String[] arr1 = {"ABCDE", "AAA", "CCC"};
    System.out.println(arr1.length);
    
    arr1[0].length(); 
  }
}

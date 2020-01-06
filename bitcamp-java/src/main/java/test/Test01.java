package test;

import java.util.Scanner;

public class Test01 {
  public static void main(String[] args) {   
    String input = "AZ";   
    toMyLowerCase(input);
  }

  public static void toMyLowerCase(String input) {
    char[] arr=input.toCharArray();

    for(int i=0; i<arr.length; i++) {
      if (65<=arr[i] && arr[i]<=90)
        arr[i]=(char)(arr[i]+32);
    }
    System.out.print(arr);
  }
}
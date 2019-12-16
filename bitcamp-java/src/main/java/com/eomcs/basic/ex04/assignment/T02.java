package com.eomcs.basic.ex04.assignment;

import java.util.Scanner;

public class T02 {
  public static void main(String[] args) {

  int i;
  int[] arr = new int[5];
  int max, min;
  
  Scanner sc = new Scanner(System.in);
  
  System.out.print("입력?");
  for (i=0; i<5; i++) {
    arr[i]=sc.nextInt();
  }
  
  max = arr[0];
  min = arr[0];
  for (i = 1; i < 5; i++) {
    if (max < arr[i]) {
      max = arr[i];
    }
    if (min > arr[i]) {
      min = arr[i];
    }
  }
  System.out.println("최대값:" +max);
  System.out.println("최소값:" +min);  
  }
} 

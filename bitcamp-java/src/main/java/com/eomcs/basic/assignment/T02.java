//#과제2 : 다섯 개의 정수 값을 입력 받고 최소, 최대 값을 구하라.
//실행 예)
//입력? 4 17 1 6 9 
//최소값 : 1
//최대값 : 17

package com.eomcs.basic.assignment;

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
  
  sc.close();
  }
} 

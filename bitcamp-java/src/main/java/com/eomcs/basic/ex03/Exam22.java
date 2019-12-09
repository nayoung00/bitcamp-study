package com.eomcs.basic.ex03;

// 리터럴 - _

public class Exam22 {
  public static void main(String[] args) {
    // 10진수 리터럴 
    System.out.println(2_3500_0000);
    System.out.println(235_000__000);
    //System.out.println(_2_3500_0000);
    //System.out.println(2_3500_0000__);


   // 8진수 리터럴
   System.out.println(01_44);
   System.out.println(0_144);
   //System.out.println(_0144);
   //System.out.println(0144_);


   // 2진수
   System.out.println(0b0110_0100);
   System.out.println(0B01_100100);
   //System.out.println(0B_01100100);
   //System.out.println(0B01100100_);
   //System.out.println(_0B01100100);


   // 16진수
   System.out.println(0x0_64);
   //System.out.println(0x_0064);
   //System.out.println(0x0064_);
   //System.out.println(_0x0064);
  }
}
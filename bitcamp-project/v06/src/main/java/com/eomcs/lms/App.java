package com.eomcs.lms;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {
     Scanner keyboard = new Scanner(System.in);

     int[] no = new int[100];
     String[] title = new String[100];
     String[] contents = new String[100];
     String[] startDate = new String[100];
     String[] endDate = new String[100];
     int[] totalHours = new int[100];
     int[] dayHours = new int[100];
     String response;
     
     int count = 0;
     for (int i = 0; i < 100; i++) {
       System.out.print("번호? ");
       no[i] = keyboard.nextInt();
       keyboard.nextLine();

       System.out.print("수업명? ");
       title[i] = keyboard.nextLine();

       System.out.print("설명? ");
       contents[i] = keyboard.nextLine();

       System.out.print("시작일? ");
       startDate[i] = keyboard.nextLine();

       System.out.print("종료일? ");
       endDate[i] = keyboard.nextLine();

       System.out.print("총수업시간? ");
       totalHours[i] = keyboard.nextInt();
       keyboard.nextLine();
       
       System.out.print("일수업시간? ");
       dayHours[i] = keyboard.nextInt();
       keyboard.nextLine();

       count++;;

       System.out.println(); 

       System.out.print("계속 입력하시겠습니까?(Y/n) ");
       response = keyboard.nextLine();
       if (!response.equalsIgnoreCase("y")) {
         break; 
       }  

     }   

     keyboard.close();

     System.out.println(); 

     for (int i = 0; i <count; i++) {
       System.out.printf("%d, %s, %s, %s ~ %s, %d, %d\n", 
           no[i], title[i], contents[i], startDate[i], 
           endDate[i],  totalHours[i], dayHours[i] );
     }
   }
 }
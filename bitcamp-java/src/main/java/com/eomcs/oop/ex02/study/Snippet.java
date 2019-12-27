package com.eomcs.oop.ex02.study;

public class Snippet {
   int spaceSize = width >> 1;
    int line = 0; 
    while (line++ < width) {
      if (line % 2 == 0) {
        continue;
      }
      
      Graphic.drawLine(spaceSize, ' ');
      spaceSize--;
      
      Graphic.drawLine(line, '$');
      System.out.println();
}


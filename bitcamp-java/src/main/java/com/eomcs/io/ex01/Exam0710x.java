// 활용 - 지정한 폴더 및 그 하위 폴더까지 모두 검색하여 파일 및 디렉토리 이름을 출력하라.
package com.eomcs.io.ex01;

import java.io.File;

public class Exam0710x {


  public static void main(String[] args) throws Exception {

    // 결과 예)
    // /Users/bitcamp/git/test
    // src/
    // mian/
    // javja/
    // com/
    // Hello.java
    // HEllo2.java
    // build.gradle
    // settings.gradle
    // Hello.java
    // ...

    File dir = new File(".");
    System.out.println(dir.getCanonicalPath());

    printList(dir, 1);
  }

  static void printList(File dir, int level) {

    File[] files = dir.listFiles();

    for (File file : files) {
      printIndent(level);

      if (file.isDirectory() && !file.isHidden()) {
        System.out.printf("%s/\n", file.getName());
        printList(file, level + 1);
      } else {
        System.out.printf("\\-- ");
        System.out.printf("%s\n", file.getName());

      }
    }
  }

  static void printIndent(int level) {
    for (int i = 0; i < level; i++) {
      System.out.printf("  ");
    }
  }
}

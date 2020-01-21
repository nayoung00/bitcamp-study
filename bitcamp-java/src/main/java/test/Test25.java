package test;

import java.util.ArrayList;

public class Test25 {
  public static void main(String[] args) {
    ArrayList pitches = new ArrayList();
    pitches.add("138");
    pitches.add("129");
    pitches.add("142");
    pitches.add("145");

    System.out.println(pitches.get(1));
    System.out.println(pitches.size());
    System.out.println(pitches.contains("142"));

    System.out.println(pitches.remove("129"));
    System.out.println(pitches.size());
    System.out.println(pitches.remove(0)); // 해당 인덱스의 항목 삭제하고 삭제한 값 리턴.

  }

}

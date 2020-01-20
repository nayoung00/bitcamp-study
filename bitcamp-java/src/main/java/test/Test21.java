package test;


public class Test21 {
  public static void main(final String[] args) throws Exception {
    final String s1 = new String("Hello");

    final char c = s1.charAt(1);
    System.out.println(c);

    System.out.println(s1.compareTo("Helli"));
    System.out.println(s1.compareTo("Hello"));
    System.out.println(s1.compareTo("Hellu"));

    System.out.println(s1.contains("ll"));
    System.out.println(s1.contains("ee"));



  }
}


package nana;

public class Test17 {
  public static void main(String[] args) {
    PersonA p1 = new PersonA("kyh", "20200");
    System.out.println(p1.printInfo());
    System.out.println(PersonA.getNationality());
  }
}

class PersonA{
  private static final String nationality = "KOR" ;
  private String name;
  private String pNum;
  private String mail;
  public PersonA() {
  }

  public PersonA(String name, String pNum) {
    this();
    this.name = name;
    this.pNum = pNum;
  }
  public PersonA(String name, String pNum, String mail) {
    this(name, pNum);
    this.mail = mail;
  }
  
  public static String getNationality() {
    return nationality;
  }

  public String printInfo() {
    String res = "";
    res += String.format("이름 : %s\n", this.name);
    res += String.format("주민번호 : %s\n", this.pNum);
    return res;
  }
}
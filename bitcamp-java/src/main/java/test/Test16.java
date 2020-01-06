package test;

public class Test16 {
  public static void main(String[] args) {
    Person p1 = new Person();
  }
}

class Person{
  private static final String nationality = " KOR";
  private String name;
  private String pNum;
  public Person() {
  }

  public Person(String name, String pNum) {
    this.name= name;
    this.pNum = pNum;
    // this = 생성된 인스턴스 자신의 주소를 가리킴;
  
  }
  public String getNationality() {
    return this.getNationality();
  }
}
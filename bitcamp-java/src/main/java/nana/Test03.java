package nana;

public class Test03 {
  public static void main(String[] args) {
    Account acc = new Account();
    acc.setAccnum("1234");
    System.out.println(acc.getAccNum());
  }
}
class Account{  
  private String accNum;
  private String owner;
  private String passwd;

  public Account() {

  }
  public void setAccnum(String accNum) {
    this.accNum = accNum;  

  }
  public String getAccNum() {
    return this.accNum;
  }
}
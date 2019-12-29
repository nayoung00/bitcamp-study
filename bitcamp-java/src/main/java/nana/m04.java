package nana;

public class m04 {
  public static void main(String[] args) {
 
        // Message Passing
        Seller s1 = new Seller(20, 30000, 2000);
        Seller s2 = new Seller(50, 10000, 4000);
        Buyer b = new Buyer(50000);
        System.out.println("------ 판매자 ------");
        System.out.println(s1);
        System.out.println("------ 판매자 ------");
        System.out.println(s2);
        System.out.println("------ 구매자 ------");
        System.out.println(b);
        
        // 거래
        b.buyApple(s1, 5);
        b.buyApple(s2, 5);
        
        System.out.println("------ 거래이후 ------");
        System.out.println("------ 판매자1 ------");
        System.out.println(s1);
        System.out.println("------ 판매자2 ------");
        System.out.println(s1);
        System.out.println("------ 구매자 ------");
        System.out.println(b);
      }
    }
    class Buyer {
      private int appleNum;
      private int money;
      
      public Buyer(int money) {
        this.appleNum = 0;
        this.money = money;
      }
      public void buyApple(Seller s, int numOfApple) {
        int applePrice = s.getApplePrice();
        int amount = applePrice * numOfApple;
        this.appleNum += s.sellApple(amount);
        this.money -= amount;    
      }  
      public String toString() {
        String res = "";
        res += String.format("보유한 사과 : %d\n", this.appleNum);
        res += String.format("현재 돈 : %d\n", this.money);
        return res;
      }
    }
    
    
    class Seller {
      private int appleNum;
      private int money;
      private final int applePrice;
      
      public Seller(int appleNum, int money, int applePrice) {
        this.appleNum = appleNum;
        this.money = money;
        this.applePrice = applePrice;
      }
      public int getApplePrice() {
        return this.applePrice;
      }
      
      public int sellApple(int amount) {
        int giveAppleNum = amount/this.applePrice;
        this.appleNum -= giveAppleNum;
        this.money += amount;
        return giveAppleNum;
      }
      public String toString() {
        String res = "";
        res += String.format("보유한 사과 : %d\n", this.appleNum);
        res += String.format("현재 돈 : %d\n", this.money);
        res += String.format("사과 가격 : %d\n", this.applePrice);
        return res;
      }
    }
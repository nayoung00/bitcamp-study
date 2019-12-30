package nana;

public class Test012 {
    public static void main(String[] args) {
      MyString str = new MyString("AZ");
      String str2 = str.myToLowerCase();
      System.out.println(str2);
    }
  }
  class MyString {
    char[] str;
    public MyString() {      
    }
    public MyString(String str) {
        this.str = str.toCharArray();
    }
    public String myToLowerCase() {        
        for(int i = 0; i < str.length; i++) {
            if(str[i] < 91)
                str[i] = (char)(str[i] + 32);
        }
        return String.valueOf(str);
    }
}

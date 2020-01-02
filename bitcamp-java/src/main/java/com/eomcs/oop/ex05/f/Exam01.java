// 상속 - 생성자 호출 순서
package com.eomcs.oop.ex05.f;

public class Exam01 {
    public static void main(String[] args) {
        C obj = new C();
        obj.v1 = 100;
        obj.v2 = 200;
        obj.v3 = 300;
        System.out.printf("v1=%d, v2=%d, v3=%d\n", obj.v1, obj.v2, obj.v3);
        
        // 생성자 호출 순서
        // 1) C 클래스의 생성자를 호출하면, 
        //    그 생성자의 첫 번째 문장이 수퍼 클래스의 생성자를 호출하는 명령이다.
        //    그래서 수퍼 클래스인 B 클래스의 생성자를 호출한다.
        // 2) B 클래스의 생성자를 호출하면,
        //    그 생성자의 첫 번째 문장이 수퍼 클래스의 생성자를 호출하는 명령이다.
        //    그래서 수퍼 클래스 A의 생성자를 호출한다.
        // 3) A 클래스의 생성자를 호출하면,
        //    그 생성자의 첫 번째 문장이 수퍼 클래스의 생성자를 호출하는 명령이다.
        //    그래서 수퍼 클래스 Object의 생성자를 호출한다.
        // 4) Object 클래스의 생성자를 호출하면,
        //    더이상 수퍼 클래스가 없기 때문에 Object() 생성자를 실행한다.
        //    그리고 이 생성자를 호출한 A 클래스의 생성자로 리턴한다.
        // 5) A 클래스의 생성자를 실행한 후 
        //    이 생성자를 호출한 B 클래스의 생성자로 리턴한다.
        // 6) B 클래스의 생성자를 실행한 후 
        //    이 생성자를 호출한 C 클래스의 생성자로 리턴한다.
        // 7) C 클래스의 생성자를 실행한다. 
        
    }
}

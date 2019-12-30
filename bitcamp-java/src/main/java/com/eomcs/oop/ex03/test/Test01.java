package com.eomcs.oop.ex03.test;

import com.eomcs.oop.ex03.test.sub.A;

class Score{
  static int count; 
  
  // 사용자 정의 데이터 타입
  String name;
  int kor;
  int eng;
  int math;
  int sum;
  float aver;
  
  //생성자 존재 이유 : 인스턴스릉 생성한 후 제대로 사용할 수 있도록 유효한 값으로 초기화. 
  Score() { //생성자는 void 붙이지 않는다.
    System.out.println("Score() - 1");
    Score.increase();
  }
  
  Score(String name, int kor, int eng, int math) { 
    System.out.println("Score() - 2");
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    this.compute();
    Score.increase();
  }
  
  static void increase() {
    Score.count++; 
  }
  
  void compute() { 
    this.sum = this.kor + this.eng + this.math;
    this.aver = this.sum / 3f;
  }
}

public class Test01 {

  public static void main(String[] args) {

    Score s1 = new Score(); 
    System.out.println("---------------");
    s1.name = "홍길동";
    s1.kor = 100;
    s1.eng = 90;
    s1.math = 80;
    s1.compute(); // s1이 가리키는 인스턴스에 대해서 계산 기능 수행. 
    Score.increase();
    
    
    Score s2 = new Score("임꺽정", 90, 80, 70);
    System.out.println("---------------");
    s2.name = "임꺽정";  
  }
}
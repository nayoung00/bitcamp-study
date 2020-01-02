package com.eomcs.oop.ex03.test;

public class Car {

  boolean on;
  int speed; 
  String model;
  String maker;
  Engine engine;
  int distance; 

  // 자동차 객체가 연산자를 통해서 유효한 값들로 적절하게 설정하게 하는 일을 함.
  Car() {
    this.engine = new Engine(4, 16, 1980);
  }

  void start() {
    this.on = true;
  }

  void stop() {
    this.on = false;
  }

  void check() {
    if (this.engine.oilState == 0) {
      this.engine.cleanOil();
      System.out.println("자동차의 엔진 오일을 교환했습니다!");
    }
    System.out.println("자동차를 정비했습니다!");
  }
}

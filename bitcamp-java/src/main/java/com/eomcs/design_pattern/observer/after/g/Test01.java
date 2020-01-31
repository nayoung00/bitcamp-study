package com.eomcs.design_pattern.observer.after.g;

public class Test01 {

  // Car 클래스를 리팩토링 한다.
  // - 옵저버에 통지하는 코드를 별도의 메서드로 분리하여
  // 유지보수 하기 좋게 만든다.

  public static void main(String[] args) {
    Car car = new Car();

    car.addCarObserver(new SafeBeltCarObserver());
    car.addCarObserver(new EngineOilCarObserver());
    car.addCarObserver(new BreakOilCarObserver());
    car.addCarObserver(new LightOffCarObserver());
    car.addCarObserver(new SunRoofCloseOilObserver());

    car.start();

    car.run();

    car.stop();

    // 업그레이드를 수행한 다음 시간이 지난 후
    // 5) 시동 끌 때 썬루프를 자동으로 닫기
    // => 썬루프를 자동으로 닫는 옵저버(SunRoofCloseCarObserver)를 정의한다.
    // => Car 객체에 등록한다.

    // 결론!
    // => 기존의 프로그래밍 방식은 특정 상태에서 수행하는 기능을 추가할 때
    // 기존 클래스에 계속 코드를 추가해야 했다.
    // => 기존 코드에 계속 새 코드를 추가하는 방식은 유지보수에 좋지 않다.
    // => Observer 패턴을 적용하면 기존 클래스를 손대지 않고
    // 특정 상태에서 수행하는 작업을 쉽게 추가할 수 있다.
  }

}



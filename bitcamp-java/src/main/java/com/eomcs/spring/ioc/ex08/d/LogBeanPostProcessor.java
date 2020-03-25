package com.eomcs.spring.ioc.ex08.d;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

// 역할 :
// => IoC 컨테이너가 빈을 생성할 때 마다 로그를 출력한다.
//
public class LogBeanPostProcessor implements BeanPostProcessor {
  public LogBeanPostProcessor() {
    System.out.println("LogBeanPostrocessor()");
  }

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    return null;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    System.out.println("===>" + bean.getClass().getName());
    return null;
  }
}
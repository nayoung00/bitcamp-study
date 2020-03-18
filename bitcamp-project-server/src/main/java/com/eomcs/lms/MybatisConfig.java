package com.eomcs.lms;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// Mybatis DAO 프록시를 자동생성할 인터페이스를 지정하기
@MapperScan("com.eomcs.lms.dao")
public class MybatisConfig {

  public MybatisConfig() {
    System.out.println("MybatisConfig 객체 생성!");
  }

  @Bean
  public SqlSessionFactory sqlSessionFactory(//
      DataSource dataSource, // DB 커넥션풀
      ApplicationContext appCtx // Spring IoC 컨테이너
  ) throws Exception {

    // Spring IoC 컨테이너 용으로 mybatis 측에서 따로 제작한
    // SqlSessionFactory 이다.
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(dataSource);
    sqlSessionFactoryBean.setTypeAliasesPackage("com.eomcs.lms.domain");
    sqlSessionFactoryBean.setMapperLocations(
        // Spring IoC 컨테이너를 통해 SQL 맵퍼 파일의 위치 정보를 가져온다.
        appCtx.getResources("classpath:com/eomcs/lms/mapper/*Mapper.xml"));

    return sqlSessionFactoryBean.getObject();
  }

}

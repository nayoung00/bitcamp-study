package com.eomcs.spring.ioc.ex12.e;

import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import com.eomcs.spring.ioc.ex12.Board;


@PropertySource("classpath:com/eomcs/spring/ioc/ex12/jdbc.properties")

// Mybatis DAO 프록시를 자동생성할 인터페이스를 지정하기
@MapperScan("com.eomcs.spring.ioc.ex12.e")

public class AppConfig {

  @Value("${jdbc.driver}")
  String jdbcDriver;

  @Value("${jdbc.url}")
  String jdbcUrl;

  @Value("${jdbc.username}")
  String jdbcUsername;

  @Value("${jdbc.password}")
  String jdbcPassword;

  @Bean
  public DataSource dataSource() {
    BasicDataSource ds = new BasicDataSource();
    ds.setDriverClassName(jdbcDriver);
    ds.setUrl(jdbcUrl);
    ds.setUsername(jdbcUsername);
    ds.setPassword(jdbcPassword);
    return ds;
  }

  @Bean
  public PlatformTransactionManager TransactionManger(DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
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
    // sqlSessionFactoryBean.setTypeAliasesPackage("com.eomcs.spring.ioc.ex12");
    sqlSessionFactoryBean.setTypeAliases(Board.class);
    sqlSessionFactoryBean.setMapperLocations(
        // Spring IoC 컨테이너를 통해 SQL 맵퍼 파일의 위치 정보를 가져온다.
        appCtx.getResources("classpath:com/eomcs/spring/ioc/ex12/e/*Mapper.xml"));

    return sqlSessionFactoryBean.getObject();
  }

}

package com.my.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // 설정용 Bean 등록 -> 내부 메서드가 자동으로 수행됨
public class WebConfig implements WebMvcConfigurer {

  private final StopWatchInterceptor interceptor;

  /* 생성자 방식 의존성 주입
  *  Dependency Injection, DI
  * 등록된 Bean 중 타입이 일치하는 Bean을 매개 변수에 주입
  * */
  @Autowired
  public WebConfig(StopWatchInterceptor interceptor) {
    this.interceptor = interceptor;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(interceptor) // 인터셉터 동작이 정의 된 Bean 추가
    .addPathPatterns("/stopwatch"); // 가로챌 요청 지정
  }
}

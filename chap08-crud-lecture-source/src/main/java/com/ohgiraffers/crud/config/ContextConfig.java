package com.ohgiraffers.crud.config;

// application 이 config 파일을 넣었다.
// bean 을 읽을수 있는 범위가 config 파일내로 줄었으므로 bean 의 확장 범위를 넓혀줘야 한다.
// beanFactory == ioc 컨테이너 == ApplicationContext 실제는 상속 구조를 가지고 있다. 그치만 같은 의미로 생각하면 된다.

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

@Configuration // 자바 방식
@ComponentScan(basePackages = "com.ohgiraffers.crud") // crud 패키지 안에 있는 빈들을 스캔한다. 스캔범위를 넓힌다.
@MapperScan(basePackages = "com.ohgiraffers.crud", annotationClass = Mapper.class)
public class ContextConfig {

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        /* comment.
        *   message.properties 파일을 자바 객체 형식으로
        *   읽어드릴 수 있게 만든다. */
        ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
        // classpath : src/main/resource, src/main/java 를 의미한다.(default 경로)
        source.setBasename("classpath:/messages/message");
        source.setDefaultEncoding("UTF-8");
        /* 제공하지 않는 언어로 요청 시에 사용할 메세지 설정 */
        Locale.setDefault(Locale.KOREA);

        return source;
    }


}


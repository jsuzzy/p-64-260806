package com.back.p64260806;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class AppConfig {

    @Bean
    public PersonRepository personRepository() {
        //어떤 객체는 초기화 작업을 매우 복잡하게 해야하는 경우가 있다.
        //빈으로등록해서 스프링부트한테 맡기면 복잡한 생성 작업 어려울 수 있음
        //세심하게 빈을 관리하고 싶으면 @Bean 방식이 좋음
        //단순하게 관리하고 싶으면 @Component 방식이 좋음
        return new PersonRepository(1);
    }

    @Bean
    public PersonRepository personRepositoryV2() {
        return new PersonRepository(2);
    }

    @Bean
    public ApplicationRunner myApplicationRunner3() {
        return args -> {
            work1();
            work2();
        };
    }

    public void work1() {
        System.out.println("work1");
    }

    public void work2() {
        System.out.println("work2");
    }

    @Bean
    @Order(1)
    public ApplicationRunner myApplicationRunner1(){
        System.out.println("myApplicationRunner1");
        return new MyApplicationRunner(1);
    }

    @Bean
    @Order(2)
    public ApplicationRunner myApplicationRunner2(){
        System.out.println("myApplicationRunner2");
        return new MyApplicationRunner(2);
    }
}

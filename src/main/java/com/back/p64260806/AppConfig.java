package com.back.p64260806;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

//    @Bean
//    public PersonService personService() {
//        System.out.println("AppConfig.personService 호출됨!");
//        return new PersonService();
//    }

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
}

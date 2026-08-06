package com.back.p64260806;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service //스프링이 알아서 new해서 객체로 등록
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(@Qualifier("personRepository") PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public int count() {
        return personRepository.count();
    }
}

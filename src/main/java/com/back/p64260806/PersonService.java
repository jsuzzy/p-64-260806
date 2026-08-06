package com.back.p64260806;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service //스프링이 알아서 new해서 객체로 등록
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public int count() {
        return personRepository.count();
    }
}

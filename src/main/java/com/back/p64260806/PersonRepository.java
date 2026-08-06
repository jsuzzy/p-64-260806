package com.back.p64260806;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class PersonRepository {

    public int count() {
        return 3;
    }

}

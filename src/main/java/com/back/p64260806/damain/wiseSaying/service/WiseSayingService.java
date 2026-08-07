package com.back.p64260806.damain.wiseSaying.service;

import com.back.p64260806.damain.wiseSaying.entity.WiseSaying;
import com.back.p64260806.damain.wiseSaying.repository.WiseSayingMemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WiseSayingService {

    private final WiseSayingMemRepository wiseSayingMemRepository;

    public WiseSaying write(String content, String author) {

        WiseSaying wiseSaying = new WiseSaying(content, author);
        wiseSayingMemRepository.save(wiseSaying);

        return wiseSaying;
    }

    public List<WiseSaying> findAll() {
        return wiseSayingMemRepository.findAll();
    }

    public WiseSaying findById(int id) {
        Optional<WiseSaying> wiseSaying = wiseSayingMemRepository.findById(id);

        //비즈니스로직을 수행하다가 발생한 예외이므로 service에 둬야함
        if(wiseSaying.isEmpty()) {
            throw new RuntimeException("%d번 명언은 존재하지 않습니다.".formatted(id));
        }

        return wiseSaying.get();
    }

    public void delete(WiseSaying wiseSaying) {
        wiseSayingMemRepository.delete(wiseSaying);
    }

    public void modify(WiseSaying wiseSaying, String content, String author) {
        wiseSaying.update(content, author);
    }
}
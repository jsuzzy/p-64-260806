package com.back.p64260806.damain.wiseSaying.controller;

import com.back.p64260806.damain.wiseSaying.entity.WiseSaying;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
@ResponseBody
public class WiseSayingController {

    private List<WiseSaying> wiseSayings = new ArrayList<>();
    private int lastId = 0;

    @GetMapping("/write")
    public String actionAdd(String content, String author) {

        //예외 사항 -> 작가 내용이 비어있음
        if(author.isEmpty()){
            throw new IllegalArgumentException("작가 내용이 비어있습니다.");
        }

        if(content.isEmpty()){
            throw new IllegalArgumentException("명언 내용이 비어있습니다.");
        }

        WiseSaying wiseSaying = new WiseSaying(content, author);
        wiseSaying.setId(++lastId);
        wiseSayings.add(wiseSaying);

        return "%d번 명언이 등록되었습니다.".formatted(wiseSaying.getId());
    }
}

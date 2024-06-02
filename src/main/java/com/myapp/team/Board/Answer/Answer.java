package com.myapp.team.Board.Answer;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Answer {
    private Integer questionNo;    // 질문 번호 (외래키)

    private String answerTitle;  // 질문 제목

    private String answerContent;    // 질문 내용

}

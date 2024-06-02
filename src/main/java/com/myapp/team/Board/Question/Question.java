package com.myapp.team.Board.Question;

import com.myapp.team.Board.Answer.Answer;
import com.myapp.team.Board.Attachment.Attachment;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    private Integer questionNo;    // 질문 번호 (자동 증가)

    private String questionTitle;  // 질문 제목

    private String questionContent;    // 질문 내용

    // 참조키라서 일단 주석 처리 필요하다면 사용, user별 질문 select하기 위해 사용함
    private Integer userNo;

    public Question(String questionTitle, String questionContent, Integer userNo) {
        this.questionTitle = questionTitle;
        this.questionContent = questionContent;
        this.userNo = userNo;
    }

    private Answer answer;

    private List<Attachment> attachments; // 다중첨부파일 리스트 (질문 1개당 여러개 파일 가능하기 때문)
}

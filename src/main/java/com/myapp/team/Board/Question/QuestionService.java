package com.myapp.team.Board.Question;

import com.myapp.team.Board.Answer.Answer;
import com.myapp.team.Board.Answer.AnswerMapper;
import com.myapp.team.Board.Attachment.Attachment;
import com.myapp.team.Board.Attachment.AttachmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private AnswerMapper answerMapper;

    @Autowired
    private AttachmentMapper attachmentMapper;

    // questiondetail (질문과 답변 보여주기 위함 => 질문 1개, 답변 1개)
    public Question getQuestionById(int questionNo) {
        Question question = questionMapper.selectQuestion(questionNo);
        if (question != null) {
            Answer answer = answerMapper.selectQuestionByNo(questionNo);

            if (answer != null) {
                question.setAnswer(answer);
            }
        }
        List<Attachment> attachments = attachmentMapper.getAttachmentsByNo(questionNo);
        question.setAttachments(attachments);
        return question;
    }

}

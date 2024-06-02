package com.myapp.team.Board.Answer;

import com.myapp.team.Board.Attachment.AttachmentService;
import com.myapp.team.Board.Question.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    private AnswerMapper answerMapper;

    @Autowired
    private AttachmentService attachmentService;
    @Autowired
    private QuestionService questionService;

    // 답변 생성 페이지 보여주는 컨트롤러
    @GetMapping("/create/{questionNo}")
    public String showAnswerCreateForm(@PathVariable("questionNo") int questionNo, Model model) {
        Answer answer = new Answer();
        answer.setQuestionNo(questionNo);
        model.addAttribute("answer", answer);
        return "CreateAnswer";
    }

    @PostMapping("/create/{questionNo}")
    public String createAnswer(@PathVariable("questionNo") int questionNo,
                               @RequestParam String answerTitle,
                               @RequestParam String answerContent) {
        Answer answer = new Answer();
        answer.setQuestionNo(questionNo);
        answer.setAnswerTitle(answerTitle);
        answer.setAnswerContent(answerContent);
        answerMapper.insertAnswer(answer);
        return "redirect:/question/" + questionNo;
    }

    @GetMapping("/update/{questionNo}")
    public String showAnswerUpdateForm(@PathVariable("questionNo") int questionNo, Model model) {
        Answer answer = answerMapper.selectQuestionByNo(questionNo);
        model.addAttribute("answer", answer);
        System.out.println(answer);
        return "UpdateAnswer";
    }

    // 답변 수정하는 컨트롤러
    @PostMapping("/update/{questionNo}")
    public String editAnswer(@PathVariable("questionNo") int questionNo,
                               @RequestParam("answerTitle") String answerTitle,
                               @RequestParam("answerContent") String answerContent) {
        answerMapper.updateAnswer(questionNo, answerTitle, answerContent);
        return "redirect:/question/" + questionNo;
    }

    // 답변 삭제하는 컨트롤러
    @PostMapping("/delete")
    public String deleteAnswer(@RequestParam("questionNo") int questionNo) {
        answerMapper.deleteAnswer(questionNo);
        return "redirect:/question/" + questionNo;
    }

}

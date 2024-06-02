package com.myapp.team.Board.Question;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface QuestionMapper {

    // 질문 제목 및 회원 일련번호만 불러오기
    @Select("select question_no, question_title, user_no from question")
    List<Question> getQuestion();

    // question_no를 통해 질문 한개씩 불러오기
    @Select("select * from question where question_no=#{questionNo}")
    Question selectQuestion(int questionNo);

    // user_no와 관련된 질문 목록 불러오기
    @Select("select * from question where user_no=#{userNo}")
    List<Question> selectQuestionById(int userNo);


    // 모든 question 불러오기
//    @Select("select * from question")
//    List<Question> selectAllQuestion();

    // question 등록
    @Insert("insert into question (question_title, question_content, user_no) values (#{questionTitle}, #{questionContent}, #{userNo})")
    @Options(useGeneratedKeys = true, keyProperty = "questionNo", keyColumn = "questionNo")   //  Mybatis DB에서 자동으로 생성된 키 값을 사용하도록 설정
    int insertQuestion(Question question);

    // question 수정
    @Update("update question set question_title=#{questionTitle}, question_content=#{questionContent} where question_no=#{questionNo}")
    int updateQuestion(int questionNo, String questionTitle, String questionContent);

    // question 삭제
    @Delete("delete from question where question_no=#{questionNo}")
    int deleteQuestion(int questionNo);

}

package com.myapp.team.Board.Answer;

import org.apache.ibatis.annotations.*;


@Mapper
public interface AnswerMapper {

    @Select("select * from answer WHERE question_no = #{questionNo}")
    Answer selectQuestionByNo(int questionNo);

    @Insert("INSERT INTO answer (question_no, answer_title, answer_content) VALUES (#{questionNo}, #{answerTitle}, #{answerContent})")
    int insertAnswer(Answer answer);

    @Update("update answer set answer_title=#{answerTitle}, answer_content=#{answerContent} where question_no = #{questionNo}")
    int updateAnswer(int questionNo, String answerTitle, String answerContent);

    @Delete("delete from answer where question_no=#{questionNo}")
    int deleteAnswer(int questionNo);
}

package com.myapp.team.Board.Attachment;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AttachmentMapper {

    @Insert("insert into attachment (attachment_no, question_no, original_filename, stored_filename, attachment_path) values (#{attachmentNo}, #{questionNo}, #{originalFilename}, #{storedFilename}, #{attachmentPath})")
    void insertAttachment(Attachment attachment);

    @Select("select * from attachment where question_no = #{questionNo}")
    List<Attachment> getAttachmentsByNo(int questionNo);

    @Select("select * from attachment where attachment_no = #{attachmentNo}")
    Attachment selectAttachmentByNo(int attachmentNo);

    @Delete("delete from attachment where attachment_no = #{attachmentNo}")
    void deleteAttachmentByNo(int attachmentNo);
}

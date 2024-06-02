package com.myapp.team.Board.Attachment;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

// 첨부파일 관련 서비스 메서드 정의
public interface AttachmentService {

    void addAttachment(Attachment attachment, MultipartFile file) throws IOException;   // 다중첨부파일 추가

    List<Attachment> getAttachmentsByNo(int questionNo);  // 질문번호에 따른 첨부파일

    Resource downloadAttachment(String storedFilename) throws MalformedURLException;

    Attachment getAttachmentNo(int attachmentNo);

    void removeAttachment(int attachmentNo);
}

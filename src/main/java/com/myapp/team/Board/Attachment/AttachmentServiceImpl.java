package com.myapp.team.Board.Attachment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Paths;
import java.util.List;

@Service    // AttachmentService(인터페이스)를 구현해서 실질적인 로직 수행(기능이 수행되도록함)
public class AttachmentServiceImpl implements AttachmentService {
    // 파일 업로드할 디렉토리 경로 지정
    private static final String UPLOAD_DIR = System.getProperty("user.dir") + "/src/main/java/com/myapp/team/Board/Attachment/uploads/";


    @Autowired
    private AttachmentMapper attachmentMapper;

    @Override
    public void addAttachment(Attachment attachment, MultipartFile file) {
        attachmentMapper.insertAttachment(attachment);
    }

    @Override
    public List<Attachment> getAttachmentsByNo(int questionNo) {
        return attachmentMapper.getAttachmentsByNo(questionNo);
    }

    @Override
    public Resource downloadAttachment(String stroedFilename) throws MalformedURLException {
        return new UrlResource(Paths.get(UPLOAD_DIR + stroedFilename).toUri());
    }

    @Override
    public Attachment getAttachmentNo(int attachmentNo) {
        return attachmentMapper.selectAttachmentByNo(attachmentNo);
    }

    @Override
    public void removeAttachment(int attachmentNo) {
        Attachment attachment = attachmentMapper.selectAttachmentByNo(attachmentNo);
        File file = new File(attachment.getAttachmentPath());
        if (file.exists()) {
            file.delete(); // 파일 시스템에서 파일 삭제
        }
        attachmentMapper.deleteAttachmentByNo(attachmentNo); // 데이터베이스에서 레코드 삭제
    }
}

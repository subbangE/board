package com.myapp.team.Board.Attachment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

@RestController
@RequestMapping("/attachments")
public class AttachmentController {

    @Autowired
    private AttachmentService attachmentService;

    // 첨부파일 데이터베이스에 업로드하는 컨트롤러
    @PostMapping
    public ResponseEntity<Attachment> addAttachment(@RequestParam("file")MultipartFile file, @RequestParam("questionNo") int questionNo ) throws IOException {
        Attachment attachment = new Attachment();
        attachment.setQuestionNo(questionNo);
        attachmentService.addAttachment(attachment, file);
        return ResponseEntity.ok().build();
    }

    // 특정 질문에 해당하는 첨부파일 목록 조회
    @GetMapping("/question/{questionNo}")
    public ResponseEntity<List<Attachment>> getAttachmentsByNo(@PathVariable("questionNo") int questionNo) {
        List<Attachment> attachments = attachmentService.getAttachmentsByNo(questionNo);
        return ResponseEntity.ok(attachments);
    }

    // 첨부파일 다운로드
    @GetMapping("/download/{storedFilename}")
    public ResponseEntity<Resource> downloadAttachment(@PathVariable String storedFilename) throws MalformedURLException {
        Resource resource = attachmentService.downloadAttachment(storedFilename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

}

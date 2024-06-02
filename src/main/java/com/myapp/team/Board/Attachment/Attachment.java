package com.myapp.team.Board.Attachment;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Attachment {

    private Integer attachmentNo;   // 첨부파일 번호

    private Integer questionNo; // 질문 번호

    private String originalFilename;    // 원본 파일명

    private String storedFilename;  // 저장된 파일명

    private String attachmentPath;  // 첨부파일 저장된 경로
}

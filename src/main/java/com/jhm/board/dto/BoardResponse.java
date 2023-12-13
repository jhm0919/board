package com.jhm.board.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardResponse {
    private Long id;                      // PK
    private String title;                 // 제목
    private String content;               // 내용
    private String author;                // 작성자
    private int view;                  // 조회수
    private Boolean deleteYn;             // 삭제 여부
    private LocalDateTime createdDate;    // 생성 일시
    private LocalDateTime modifiedDate;   // 최종 수정 일시
}

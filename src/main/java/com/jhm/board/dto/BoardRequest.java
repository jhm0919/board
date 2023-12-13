package com.jhm.board.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardRequest {

    private Long id;             // PK
    private String title;        // 제목
    private String content;      // 내용
    private String author;       // 작성자
}

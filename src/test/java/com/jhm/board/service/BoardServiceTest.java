package com.jhm.board.service;

import com.jhm.board.dto.BoardRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BoardServiceTest {

    @Autowired
    BoardService boardService;


    @Test
    void saveBoard() {
        BoardRequest params = new BoardRequest();
        params.setTitle("제목");
        params.setContent("내용");
        params.setAuthor("글쓴이");

        Long id = boardService.saveBoard(params);
        System.out.println("id = " + id);
    }

    @Test
    void saveByForeach() {
        for (int i = 1; i <= 1000; i++) {
            BoardRequest params = new BoardRequest();
            params.setTitle(i + "번 게시글 제목");
            params.setContent(i + "번 게시글 내용");
            params.setAuthor("테스터" + i);
            boardService.saveBoard(params);
        }
    }

    @Test
    void findBoardById() {
    }

    @Test
    void updateBoard() {
    }

    @Test
    void deleteBoard() {
    }

    @Test
    void findAllBoard() {
    }
}
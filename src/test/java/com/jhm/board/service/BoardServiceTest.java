package com.jhm.board.service;

import com.jhm.board.dto.BoardRequest;
import com.jhm.board.dto.BoardResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BoardServiceTest {

    @Autowired
    BoardService boardService;


    @Test
    void save() {
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
    void findById() {
        BoardRequest params = new BoardRequest();
        params.setTitle("제목1");
        params.setContent("내용1");
        params.setAuthor("작성자1");
        Long id = boardService.saveBoard(params);

        BoardResponse boardById = boardService.findBoardById(id);
//        Assertions.assertThat(boardById.getId()).isEqualTo(5);
    }

    @Test
    void update() {
        BoardRequest params = new BoardRequest();
        params.setId(5L);
        params.setTitle("제목 수정");
        params.setContent("내용 수정");
        params.setAuthor("작성자 수정");

        boardService.updateBoard(params);
    }

    @Test
    void delete() {
        boardService.deleteBoard(4L);

        BoardResponse boardById = boardService.findBoardById(4L);
        Boolean deleteYn = boardById.getDeleteYn();

        assertThat(deleteYn).isEqualTo(true);
    }

    @Test
    void findAll() {
    }


}
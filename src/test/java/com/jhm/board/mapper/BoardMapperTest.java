package com.jhm.board.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.jhm.board.dto.BoardRequest;
import com.jhm.board.dto.BoardResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BoardMapperTest {

    @Autowired
    BoardMapper boardMapper;

//    @Test
//    void save() {
//        BoardRequest params = new BoardRequest();
//        params.setTitle("1번 게시글 제목");
//        params.setContent("1번 게시글 내용");
//        params.setAuthor("테스터");
//        boardMapper.save(params);
//
//        List<BoardResponse> posts = boardMapper.findAll();
//        System.out.println("전체 게시글 개수는 : " + posts.size() + "개입니다.");
//    }

    @Test
    void findById() {
        BoardResponse board = boardMapper.findById(1L);
        try {
            String postJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(board);
            System.out.println(postJson);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void update() {
        BoardRequest params = new BoardRequest();

        params.setId(1L);
        params.setTitle("1번 게시글 제목 수정합니다.");
        params.setContent("1번 게시글 내용 수정합니다.");
        params.setAuthor("장해민");

        boardMapper.update(params);

        BoardResponse board = boardMapper.findById(1L);

        try {
            String postJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(board);
            System.out.println(postJson);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

//    @Test
//    void deleteById() {
//        System.out.println("삭제 이전의 전체 게시글 개수는 : " + boardMapper.findAll().size() + "개입니다.");
//        boardMapper.deleteById(1L);
//        System.out.println("삭제 이후의 전체 게시글 개수는 : " + boardMapper.findAll().size() + "개입니다.");
//    }

    @Test
    void findAll() {
    }
}
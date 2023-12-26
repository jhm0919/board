package com.jhm.board.mapper;

import com.jhm.board.dto.BoardRequest;
import com.jhm.board.dto.BoardResponse;
import com.jhm.board.dto.SearchDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper
public interface BoardMapper {

    /**
     * 게시글 저장
     * @param params - 게시글 정보
     */
    void save(BoardRequest params);
    /**
     * 게시글 상세정보 조회
     * @param id - PK
     * @return 게시글 상세정보
     */
    BoardResponse findById(Long id);
    /**
     * 게시글 수정
     * @param params - 게시글 정보
     */
    void update(BoardRequest params);
    /**
     * 게시글 삭제
     * @param id - PK
     */
    void deleteById(Long id);
    /**
     * 게시글 리스트 조회
     * @return 게시글 리스트
     */
    List<BoardResponse> findAll(SearchDto params);
    /**
     * 게시글 수 카운팅
     * @return 게시글 수
     */
    int count(SearchDto params);
}

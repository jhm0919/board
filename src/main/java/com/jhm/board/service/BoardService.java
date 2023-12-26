package com.jhm.board.service;

import com.jhm.board.dto.BoardRequest;
import com.jhm.board.dto.BoardResponse;
import com.jhm.board.dto.SearchDto;
import com.jhm.board.mapper.BoardMapper;
import com.jhm.board.paging.Pagination;
import com.jhm.board.paging.PagingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;

    @Transactional
    public Long saveBoard(final BoardRequest params) {
        boardMapper.save(params);
        return params.getId();
    }

    @Transactional
    public BoardResponse findBoardById(final Long id) {
        return boardMapper.findById(id);
    }

    @Transactional
    public Long updateBoard(final BoardRequest params) {
        boardMapper.update(params);
        return params.getId();
    }

    @Transactional
    public Long deleteBoard(final Long id) {
        boardMapper.deleteById(id);
        return id;
    }

    /**
     * 게시글 리스트 조회
     * @param params - search conditions
     * @return list & pagination information
     */
    @Transactional
    public PagingResponse<BoardResponse> findAllBoard(final SearchDto params) {
        // 조건에 해당하는 데이터가 없는 경우, 응답 데이터에 비어있는 리스트와 null을 담아 반환
        int count = boardMapper.count(params);
        if (count < 1) { // 게시물이 없으면
            return new PagingResponse<>(Collections.emptyList(), null);
        }

        // Pagination 객체를 생성해서 페이지 정보 계산 후 SearchDto 타입의 객체인 params에 계산된 페이지 정보 저장
        Pagination pagination = new Pagination(count, params);
        params.setPagination(pagination);

        // 계산된 페이지 정보의 일부(limitStart, recordSize)를 기준으로 리스트 데이터 조회 후 응답 데이터 반환
        List<BoardResponse> list = boardMapper.findAll(params);
        return new PagingResponse<>(list, pagination);
    }

}

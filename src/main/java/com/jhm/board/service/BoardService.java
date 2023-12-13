package com.jhm.board.service;

import com.jhm.board.dto.BoardRequest;
import com.jhm.board.dto.BoardResponse;
import com.jhm.board.mapper.BoardMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {
    private final BoardMapper boardMapper;

    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

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

    @Transactional
    public List<BoardResponse> findAllBoard(Pageable pageable) {
        return boardMapper.findAll(pageable);
    }

}

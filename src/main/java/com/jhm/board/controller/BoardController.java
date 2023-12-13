package com.jhm.board.controller;

import com.jhm.board.dto.BoardRequest;
import com.jhm.board.dto.BoardResponse;
import com.jhm.board.dto.MessageDto;
import com.jhm.board.service.BoardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BoardController {

    private BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/")
    public String list(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC)Pageable pageable, Model model) {
        List<BoardResponse> boardList = boardService.findAllBoard(pageable);
        model.addAttribute("boardList", boardList);
        return "board/list";
    }

    @GetMapping("/post")
    public String post() {
        return "board/post";
    }

    @PostMapping("/post")
    public String post(BoardRequest params, Model model) {
        boardService.saveBoard(params);
        MessageDto message = new MessageDto("게시글 생성이 완료되었습니다.", "/", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }

    @GetMapping("/post/{id}")
    public String detail(@PathVariable Long id, Model model) {
        BoardResponse boardById = boardService.findBoardById(id);
        model.addAttribute("post", boardById);
        return "board/detail";
    }

    @GetMapping("/post/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        BoardResponse boardById = boardService.findBoardById(id);
        model.addAttribute("post", boardById);
        return "board/edit";
    }

    @PutMapping("/post/edit/{id}")
    public String edit(BoardRequest params, Model model) {
        boardService.updateBoard(params);
        MessageDto message = new MessageDto("게시글 수정이 완료되었습니다.", "/", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }

    @PutMapping("/post/{id}")
    public String delete(@PathVariable Long id, Model model) {
        boardService.deleteBoard(id);
        MessageDto message = new MessageDto("게시글 삭제가 완료되었습니다.", "/", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }

    //사용자에게 메시지를 전달하고, 페이지를 리다이렉트 한다.
    private String showMessageAndRedirect(final MessageDto params, Model model) {
        model.addAttribute("params", params);
        return "common/messageRedirect";
    }
}

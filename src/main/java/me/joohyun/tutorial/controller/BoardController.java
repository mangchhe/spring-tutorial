package me.joohyun.tutorial.controller;

import lombok.RequiredArgsConstructor;
import me.joohyun.tutorial.domain.Board;
import me.joohyun.tutorial.dto.BoardDto;
import me.joohyun.tutorial.service.BoardService;
import me.joohyun.tutorial.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final UserService userService;

    @GetMapping("board/list")
    private String viewBoardList(Model model){
        model.addAttribute("boardlist",boardService.findBoardALL());

        return "boards/list";
    }

    @GetMapping("board/listbyuser")
    private String viewBoardListByUser(Model model, Principal principal){
        model.addAttribute("boardlist", boardService.findBoardByUser(userService.findByEmail(principal.getName())));
        return "boards/listbyuser";
    }

    @GetMapping("board/new")
    private String createBoard(Model model){
        model.addAttribute("boardDto", new BoardDto());
        return "boards/new";
    }

    @PostMapping("board/new")
    private String createBoardForm(@Valid BoardDto boardDto, BindingResult result, Principal principal){

        if(result.hasErrors()){
            return "boards/new";
        }

        boardService.createBoard(Board.builder()
                .title(boardDto.getTitle())
                .content(boardDto.getContent())
                .board_date(LocalDateTime.now())
                .user(userService.findByEmail(principal.getName()))
                .build());

        return "redirect:/";

    }
}

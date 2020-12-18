package me.joohyun.tutorial.service;

import me.joohyun.tutorial.domain.Board;
import me.joohyun.tutorial.domain.User;
import me.joohyun.tutorial.repository.BoardRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class BoardServiceTest {

    @Autowired BoardService boardService;
    @Autowired BoardRepository boardRepository;
    
    @Test
    public void 게시글_생성() throws Exception {
        //given
        User user = new User("mangchhe@naver.com","qwer1234");
        Board board = new Board("제목1", "내용1", LocalDateTime.now(), user);
        //when
        Long result = boardService.createBoard(board);
        //then
        Assertions.assertThat(board).isEqualTo(boardRepository.findOne(result));
    }
    @Test
    public void 전체게시글보기() throws Exception {
        //given
        User user = new User("mangchhe@naver.com","qwer1234");
        Board board = new Board("제목1", "내용1", LocalDateTime.now(), user);
        Board board2 = new Board("제목2", "내용2", LocalDateTime.now(), user);
        Board board3 = new Board("제목3", "내용3", LocalDateTime.now(), user);
        Board board4 = new Board("제목4", "내용4", LocalDateTime.now(), user);
        //when
        boardService.createBoard(board);
        boardService.createBoard(board2);
        boardService.createBoard(board3);
        boardService.createBoard(board4);
        //then
        if(boardService.findBoardALL().size() == 4){

        }else{
            fail();
        }
    }
    @Test
    public void 게시글_삭제() throws Exception {
        //given
        User user = new User("mangchhe@naver.com","qwer1234");
        Board board = new Board("제목1", "내용1", LocalDateTime.now(), user);
        //when
        Board result = boardService.removeBoard(board);
        //then
        if(boardService.findBoardALL().isEmpty()){

        }else{
            fail();
        }
    }
}
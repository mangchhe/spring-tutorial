package me.joohyun.tutorial.service;

import lombok.RequiredArgsConstructor;
import me.joohyun.tutorial.domain.Board;
import me.joohyun.tutorial.domain.User;
import me.joohyun.tutorial.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {

    private final BoardRepository br;

    /**
     * 게시글 생성
     */
    public Long createBoard(Board board){
        br.save(board);
        return board.getId();
    }
    /**
     * 게시글 수정
     */

    /**
     * 전체 게시글 보기
     */
    public List<Board> findBoardALL(){
        return br.findAll();
    }
    /**
     * 해당 사용자 게시글 보기
     */
    public List<Board> findBoardByUser(User user){
        return br.findAllByUser(user);
    }
    /**
     * 게시글 삭제
     */
    public Board removeBoard(Board board){
        br.delete(board);
        return board;
    }
}

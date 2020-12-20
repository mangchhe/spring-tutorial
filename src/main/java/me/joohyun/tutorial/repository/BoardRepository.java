package me.joohyun.tutorial.repository;

import me.joohyun.tutorial.domain.Board;
import me.joohyun.tutorial.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BoardRepository {

    @PersistenceContext
    private EntityManager em;

    public Board save(Board board){
        em.persist(board);
        return board;
    }

    public Board findOne(Long id){
        return em.find(Board.class, id);
    }

    public List<Board> findAll(){
        return em.createQuery("select b from Board b", Board.class)
                .getResultList();
    }

    public List<Board> findAllByUser(User user){
        return em.createQuery("select b from Board b where b.user = :user", Board.class)
                .setParameter("user", user)
                .getResultList();
    }

    public Board delete(Board board){
        em.remove(board);
        return board;
    }
}

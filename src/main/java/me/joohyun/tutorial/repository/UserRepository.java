package me.joohyun.tutorial.repository;

import me.joohyun.tutorial.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    public User save(User user){
        em.persist(user);
        return user;
    }

    public User findOne(Long id){
        return em.find(User.class, id);
    }

    public User findByEmail(String email){
        return em.createQuery("select u from User u where u.email = :email", User.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    public List<User> findByEmails(String email){
        return em.createQuery("select u from User u where u.email = :email", User.class)
                .setParameter("email", email)
                .getResultList();
    }

    public List<User> findAll(){
        return em.createQuery("select u from User u", User.class)
                .getResultList();
    }
}

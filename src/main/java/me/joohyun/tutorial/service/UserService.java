package me.joohyun.tutorial.service;

import lombok.RequiredArgsConstructor;
import me.joohyun.tutorial.domain.User;
import me.joohyun.tutorial.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository ur;

    /**
     * 회원가입
     */
    public Long singup(User user){
        if(!ur.findByEmail(user.getEmail()).isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
        ur.save(user);
        return user.getId();
    }
    /**
     * 로그인
     */

    /**
     * 회원목록 조회
     */
    @Transactional(readOnly = true)
    public List<User> findUserAll(){
        return ur.findAll();
    }
}
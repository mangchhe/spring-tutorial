package me.joohyun.tutorial.service;

import me.joohyun.tutorial.domain.User;
import me.joohyun.tutorial.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired UserService userService;
    @Autowired UserRepository userRepository;

    @Test
    public void 회원가입() throws Exception {
        //given
        User user = new User("mangchhe@naver.com", "qwer1234");
        //when
        Long result = userService.singup(user);
        //then
        Assertions.assertThat(user).isEqualTo(userRepository.findOne(result));
    }

    @Test
    public void 중복_회원가입() throws Exception {
        //given
        User user = new User("mangchhe@naver.com", "qwer1234");
        User user2 = new User("mangchhe@naver.com", "qwer123");
        //when
        userService.singup(user);
        try {
            userService.singup(user2);
        }catch (IllegalStateException e){
            return;
        }
        //then
        fail();
    }

    @Test
    public void 전체사용자보기() throws Exception {
        //given
        User user = new User("mangchhe@naver.com", "qwer1234");
        User user2 = new User("mangchh@naver.com", "qwer1234");
        User user3 = new User("mangch@naver.com", "qwer1234");
        User user4 = new User("mangc@naver.com", "qwer1234");
        //when
        userService.singup(user);
        userService.singup(user2);
        userService.singup(user3);
        userService.singup(user4);
        //then
        if (userService.findUserAll().size() == 4){
        }
        else{
            fail();
        }
    }

}
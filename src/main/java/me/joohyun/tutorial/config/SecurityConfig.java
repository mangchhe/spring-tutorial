package me.joohyun.tutorial.config;

import me.joohyun.tutorial.config.oauth.PrincipalOauth2UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// 1. 코드 받기(인증) 2. 엑세스토큰(권한) 받고 3. 시큐리티 서버가 구글 로그인 사용자의 권한이 생김(사용자 프로필 정보를 가져오고)
// 4-1. 그 정보를 토대로 회원가입을 자동으로 진행
// 4-2. 구글(이메일, 전화번호, 이름, 아이디) 쇼핑몰 운영(vip 등급, 집주소 등이 필요)
// 추가적인 회원가입 창이 생겨서 회원가입을 해야한다.
// Tip. 코드 X (액세스토큰 + 사용자프로필정보 O)

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true) // secured 어노테이션 활성화, preAuthorize, postAuthorize 어노테이션 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PrincipalOauth2UserService principalOauth2UserService;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
    }

    @Bean
    public BCryptPasswordEncoder encoderPwd(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/board/**").access("hasRole('ROLE_USER')")
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/user/login")
                .loginProcessingUrl("/user/login")
                .defaultSuccessUrl("/")
                .and()
                .logout()
                .logoutUrl("/user/logout")
                .logoutSuccessUrl("/")
                .and()
                .oauth2Login()
                .loginPage("/user/login")
                .userInfoEndpoint()
                .userService(principalOauth2UserService);
    }
}

package me.joohyun.tutorial.config.auth;

import lombok.RequiredArgsConstructor;
import me.joohyun.tutorial.domain.User;
import me.joohyun.tutorial.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repository.findByEmail(username);
        if(user == null){
            return null;
        }
        return new PrincipalDetails(user);


    }
}

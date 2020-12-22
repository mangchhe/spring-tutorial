package me.joohyun.tutorial.controller;

import lombok.RequiredArgsConstructor;
import me.joohyun.tutorial.config.auth.PrincipalDetails;
import me.joohyun.tutorial.domain.User;
import me.joohyun.tutorial.dto.UserDto;
import me.joohyun.tutorial.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("user")
    private @ResponseBody String user(@AuthenticationPrincipal PrincipalDetails principalDetails){
        System.out.println(principalDetails.getUser());
        return "hello";
    }

    @GetMapping("user/signup")
    private String signup(Model model){
        model.addAttribute("userDto", new UserDto());
        return "users/signup";
    }

    @PostMapping("user/signup")
    private String signupForm(@Valid UserDto userDto, BindingResult result){
        if(result.hasErrors()){
            return "users/signup";
        }
        userService.singup(
                User.builder()
                        .email(userDto.getEmail())
                        .password(bCryptPasswordEncoder.encode(userDto.getPassword()))
                        .role("ROLE_USER")
                        .build()
        );
        return "redirect:/";
    }

    @GetMapping("user/login")
    private String login(Principal principal){
        try {
            principal.getName();
            return "redirect:/";
        }catch (NullPointerException e){
            return "users/login";
        }
    }

    @GetMapping("user/list")
    private String viewMemberList(Model model){
        model.addAttribute("userlist", userService.findUserAll());
        return "users/list";
    }

    @GetMapping("user/logout")
    private @ResponseBody
    String logout(){
        return "users/logout";
    }
}

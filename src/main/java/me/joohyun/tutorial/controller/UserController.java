package me.joohyun.tutorial.controller;

import lombok.RequiredArgsConstructor;
import me.joohyun.tutorial.domain.User;
import me.joohyun.tutorial.dto.UserDto;
import me.joohyun.tutorial.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

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

        userService.singup(new User(userDto.getEmail(), userDto.getPassword()));

        return "redirect:/";

    }

    @GetMapping("user/login")
    private String login(){
        return "users/login";
    }

    @GetMapping("user/list")
    private String viewMemberList(Model model){
        model.addAttribute("userlist", userService.findUserAll());
        return "users/list";
    }
}

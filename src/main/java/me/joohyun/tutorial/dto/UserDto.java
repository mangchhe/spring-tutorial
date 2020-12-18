package me.joohyun.tutorial.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter @Setter
public class UserDto {
    @NotEmpty(message = "이메일 입력은 필수입니다.")
    private String email;
    @NotEmpty(message = "이메일 입력은 필수입니다.")
    @Size(min = 6, max = 18)
    @Pattern(regexp = "^[a-zA-z0-9]*$")
    private String password;
}

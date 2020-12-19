package me.joohyun.tutorial.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Getter
@Setter
public class BoardDto {

    @NotEmpty(message = "제목을 입력해야합니다.")
    private String title;
    @NotEmpty(message = "내용을 입력해야합니다.")
    private String content;

}

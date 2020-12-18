package me.joohyun.tutorial.dto;

import lombok.Getter;
import lombok.Setter;
import me.joohyun.tutorial.domain.User;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Getter
@Setter
public class BoardDto {

    @NotEmpty
    private String title;
    @NotEmpty
    private String content;
    @NotEmpty
    private LocalDateTime board_date;
    @NotEmpty
    private User user;

}

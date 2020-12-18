package me.joohyun.tutorial.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Board {

    @Id
    @Column(name = "board_id")
    @GeneratedValue
    private Long id;

    private String title;
    private String content;
    private LocalDateTime board_date;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public Board(){

    }

    public Board(String title, String content, LocalDateTime board_date, User user) {
        this.title = title;
        this.content = content;
        this.board_date = board_date;
        this.user = user;
    }
}

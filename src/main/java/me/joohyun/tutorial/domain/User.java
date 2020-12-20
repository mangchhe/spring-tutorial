package me.joohyun.tutorial.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue
    private Long id;

    private String email;
    private String password;
    private String role;
    private Timestamp loginDate;
    private Timestamp createDate;

    public User(){}

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}

package com.java.btoo.Domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserTbl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String password;

    private String nickname;

    private long grade;

    private long ban;

    private LocalDateTime joindate = LocalDateTime.now();

    private long score;

    public UserTbl(String password, String nickname, long grade, long ban, long score) {
        this.password = password;
        this.nickname = nickname;
        this.grade = grade;
        this.ban = ban;
        this.score = score;
    }
}

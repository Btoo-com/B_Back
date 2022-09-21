package com.java.btoo.Domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class User {
    private long id;
    private String password;
    private String nickname;
    private long grade;
    private long ban;
    private java.sql.Timestamp join;
    private long score;

    public User(long id, String password, String nickname,long grade, long ban, java.sql.Timestamp join,long score){
        this.id=id;
        this.password=password;
        this.nickname=nickname;
        this.grade=grade;
        this.ban=ban;
        this.join=join;

        this.score=score;

    }
}

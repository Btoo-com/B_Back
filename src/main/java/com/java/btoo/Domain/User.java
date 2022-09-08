package com.java.btoo.Domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class User {
    private String id;
    private String password;
    private String nickname;
    private long grade;
    private long Class;
    private java.sql.Timestamp join;

    public User(String id, String password, String nickname,long grade, long Class, java.sql.Timestamp join){
        this.id=id;
        this.password=password;
        this.nickname=nickname;
        this.grade=grade;
        this.Class=Class;
        this.join=join;
    }
}

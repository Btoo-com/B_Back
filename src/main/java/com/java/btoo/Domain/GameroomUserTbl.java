package com.java.btoo.Domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@ToString
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GameroomUserTbl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gameroom_user_id;
    private long user_id;
    private long room_id;

    public GameroomUserTbl(long user_id, long room_id){
        this.user_id=user_id;
        this.room_id=room_id;
    }
}

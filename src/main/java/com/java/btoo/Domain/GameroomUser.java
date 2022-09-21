package com.java.btoo.Domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class GameroomUser {
    private long user_id;
    private long room_id;

    public GameroomUser(long user_id, long room_id){
        this.user_id=user_id;
        this.room_id=room_id;
    }
}

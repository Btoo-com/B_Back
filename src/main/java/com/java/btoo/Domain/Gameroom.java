package com.java.btoo.Domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Gameroom {
    private long room_id;
    private String room_name;
    private long host_id;

    public Gameroom(long room_id, String room_name,long host_id){
        this.room_id=room_id;
        this.room_name=room_name;
        this.host_id=host_id;
    }
}

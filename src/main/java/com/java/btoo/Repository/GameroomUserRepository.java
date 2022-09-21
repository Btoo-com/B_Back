package com.java.btoo.Repository;

import com.java.btoo.Domain.GameroomUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface GameroomUserRepository {
    @Insert("insert into Gameroom_user values(#{user_id},#{room_id})")
    void joinRoom(GameroomUser gameroomUser);
}

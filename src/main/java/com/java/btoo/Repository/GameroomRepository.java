package com.java.btoo.Repository;

import com.java.btoo.Domain.Gameroom;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface GameroomRepository {
    @Insert("insert into Gameroom values(#{room_id},#{room_name},#{host_id})")
    void makeroom(Gameroom gameroom);

}

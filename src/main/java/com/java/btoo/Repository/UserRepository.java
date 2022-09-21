package com.java.btoo.Repository;

import com.java.btoo.Domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserRepository {

    @Insert("insert into User values(#{id},#{password},#{nickname},#{grade},#{ban},#{join},#{score})")
    void getSignup(User user);

    @Update("update User set score = score+1 where id=#{id}")
    String ScoreUp(@Param("id")String id);
}

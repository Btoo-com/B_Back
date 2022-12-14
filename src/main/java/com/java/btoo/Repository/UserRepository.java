package com.java.btoo.Repository;

import com.java.btoo.Domain.UserTbl;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Mapper
public interface UserRepository extends JpaRepository<UserTbl,Long> {
    List<UserTbl> findAllByOrderByScoreDesc();

    Optional<Object> findByNickname(String email);
}

package com.java.btoo.Repository;

import com.java.btoo.Domain.GameroomUserTbl;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface GameroomUserRepository extends JpaRepository<GameroomUserTbl,Long> {

}

package com.java.btoo.Repository;

import com.java.btoo.Domain.GameroomTbl;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Mapper
public interface GameroomRepository extends JpaRepository<GameroomTbl,Long> {


}

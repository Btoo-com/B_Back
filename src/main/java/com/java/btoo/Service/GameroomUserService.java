package com.java.btoo.Service;

import com.java.btoo.Domain.GameroomUserTbl;
import com.java.btoo.Repository.GameroomUserRepository;
import jdk.jfr.StackTrace;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@NoArgsConstructor
@Service
public class GameroomUserService {

    @Autowired
    private GameroomUserRepository gameroomUserRepository;

    @Transactional
    public void delete(Long id){
        GameroomUserTbl gameroomUserTbl = gameroomUserRepository.findById(id)
                            .orElseThrow(()->new RuntimeException());
        gameroomUserRepository.delete(gameroomUserTbl);
    }
}

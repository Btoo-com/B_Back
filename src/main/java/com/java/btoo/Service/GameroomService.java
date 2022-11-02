package com.java.btoo.Service;

import com.java.btoo.Domain.GameroomTbl;
import com.java.btoo.Repository.GameroomRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@AllArgsConstructor
@Service
public class GameroomService {

    @Autowired
    private GameroomRepository gameroomRepository;

    @Transactional
    public void delete(Long id){
        GameroomTbl gameroomTbl = gameroomRepository.findById(id)
                        .orElseThrow(()->new RuntimeException());
        gameroomRepository.delete(gameroomTbl);
    }
}

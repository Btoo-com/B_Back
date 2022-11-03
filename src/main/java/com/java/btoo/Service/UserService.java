package com.java.btoo.Service;

import com.java.btoo.Domain.UserTbl;
import com.java.btoo.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@AllArgsConstructor
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void delete(Long id){
        UserTbl userTbl = userRepository.findById(id)
                .orElseThrow(()->new RuntimeException());
        userRepository.delete(userTbl);
    }
    @Transactional
    public long addScore(Long id){
        UserTbl user = userRepository.findById(id)
                .orElseThrow(()->new RuntimeException());
        user.setScore(user.getScore()+1);
        userRepository.save(user);
        return userRepository.findById(id).get().getScore();
    }
}

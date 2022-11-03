package com.java.btoo.Controller;

import com.java.btoo.Domain.UserTbl;
import com.java.btoo.Repository.UserRepository;
import com.java.btoo.Service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/signup", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public UserTbl SignUp(UserTbl user)throws Exception{
        return userRepository.save(user);
    }
    @ResponseBody//탈퇴하기
    @RequestMapping(value = "/secession", method = RequestMethod.DELETE, produces = "application/json; charset=utf-8")
    public String Secession(@Param("id")Long id)throws Exception{
        userService.delete(id);
        return "success";
    }
    @ResponseBody //랭킹보여주기
    @RequestMapping(value = "/rank", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public List<UserTbl> Rank()throws Exception{
        return userRepository.findAllByOrderByScoreDesc();
    }
    @ResponseBody//우승했을 때 점수추가
    @RequestMapping(value = "/score", method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
    public Long getScore(@Param("id")Long id){
        return userService.addScore(id);
    }
}

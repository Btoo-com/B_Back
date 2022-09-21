package com.java.btoo.Controller;

import com.java.btoo.Domain.User;
import com.java.btoo.Repository.UserRepository;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @ResponseBody
    @RequestMapping(value = "/signup", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public String SignUp(@ModelAttribute User user)throws Exception{
        userRepository.getSignup(user);
        return "sign up success";
    }
    @ResponseBody
    @RequestMapping(value = "/scoreup", method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
    public String ScoreUp(@Param("id")String id)throws Exception{
        userRepository.ScoreUp(id);
        return "score up success";
    }


}

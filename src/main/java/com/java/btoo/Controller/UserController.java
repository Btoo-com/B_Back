package com.java.btoo.Controller;

import com.java.btoo.Domain.UserTbl;
import com.java.btoo.Provider.JwtTokenProvider;
import com.java.btoo.Repository.UserRepository;
import com.java.btoo.Service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
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

    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @ResponseBody
    @RequestMapping(value = "/signup", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public UserTbl SignUp(UserTbl user)throws Exception{
        return userRepository.save(user);
    }
    @PostMapping("/login")
    public String login(@Param("nickname")String nickname, @Param("password")String password) {
        UserTbl user = (UserTbl) userRepository.findByNickname(nickname)
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 이름 입니다."));
        String pw = user.getPassword();
        if(pw != password) throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        return jwtTokenProvider.createToken(user.getNickname(), user.getRoles());
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
    //aaa
    @ResponseBody//우승했을 때 점수추가
    @RequestMapping(value = "/score", method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
    public Long getScore(@Param("id")Long id){
        return userService.addScore(id);
    }
}

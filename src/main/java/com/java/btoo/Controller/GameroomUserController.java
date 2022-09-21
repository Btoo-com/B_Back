package com.java.btoo.Controller;

import com.java.btoo.Domain.Gameroom;
import com.java.btoo.Domain.GameroomUser;
import com.java.btoo.Repository.GameroomUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin
@Controller
public class GameroomUserController {
    @Autowired
    private GameroomUserRepository gameroomUserRepository;

    @RequestMapping(value = "/joinroom", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public String joinRoom(@ModelAttribute GameroomUser gameroomUser)throws Exception {
        return "success";
        }
    }

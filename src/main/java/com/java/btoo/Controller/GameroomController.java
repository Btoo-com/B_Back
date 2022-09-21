package com.java.btoo.Controller;

import com.java.btoo.Domain.Gameroom;
import com.java.btoo.Repository.GameroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
public class GameroomController {
    @Autowired
    private GameroomRepository gameroomRepository;

    @ResponseBody
    @RequestMapping(value = "/makeroom", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public String makeGameroom(@ModelAttribute Gameroom gameroom)throws Exception{
        gameroomRepository.makeroom(gameroom);
        return "success";
    }
}


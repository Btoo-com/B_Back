package com.java.btoo.Controller;

import com.java.btoo.Repository.GameroomUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Controller
public class GameroomUserController {
    @Autowired
    private GameroomUserRepository gameroomUserRepository;
}

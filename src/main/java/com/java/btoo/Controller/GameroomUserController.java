package com.java.btoo.Controller;

import com.java.btoo.Domain.GameroomUserTbl;
import com.java.btoo.Repository.GameroomUserRepository;
import com.java.btoo.Service.GameroomUserService;
import org.apache.ibatis.annotations.Param;
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

    @Autowired
    private GameroomUserService gameroomUserService;

    @RequestMapping(value = "/joinroom", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public String joinRoom(GameroomUserTbl gameroomUser) throws Exception {
        gameroomUserRepository.save(gameroomUser);
        return "success";
    }

    @RequestMapping(value = "/exitroom", method = RequestMethod.DELETE, produces = "application/json; charset=utf-8")
    public String exitRoom(@Param("id")Long id) throws Exception {
        gameroomUserService.delete(id);
        return "success";
    }
}

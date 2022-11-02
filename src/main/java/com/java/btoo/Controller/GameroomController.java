package com.java.btoo.Controller;

import com.java.btoo.Domain.GameroomTbl;
import com.java.btoo.Domain.UserTbl;
import com.java.btoo.Service.GameroomService;
import com.java.btoo.Repository.GameroomRepository;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
public class GameroomController {
    @Autowired
    private GameroomRepository gameroomRepository;

    @Autowired
    private GameroomService gameroomService;

    @ResponseBody
    @RequestMapping(value = "/makeroom", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public GameroomTbl makeGameroom(GameroomTbl gameroom)throws Exception{
        GameroomTbl value = gameroomRepository.save(gameroom);
        return value;

    }
    @ResponseBody
    @RequestMapping(value = "/endroom", method = RequestMethod.DELETE, produces = "application/json; charset=utf-8")
    public String endGameroom(@Param("id")Long id)throws Exception {
        gameroomService.delete(id);
        return "success";
    }
    @ResponseBody
    @RequestMapping(value = "/getrooms", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public List<GameroomTbl> ListRoom() throws Exception {
        return gameroomRepository.findAll();
        }

    }


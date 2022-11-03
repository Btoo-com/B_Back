package com.java.btoo.Controller;

import com.java.btoo.Service.OpenAPIService;
import org.apache.ibatis.annotations.Param;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
public class RestOpenApiController {
    @Autowired
    private OpenAPIService openAPIService;

    @GetMapping("api")
    @ResponseBody
    public List<String> CallApiWithJson(@Param("search")String search) {
        JSONObject json = openAPIService.getJSON(search);
        JSONObject object = openAPIService.OneParsing(json);
        String word =  openAPIService.GetWord(object);
        String definition = openAPIService.getDefinition(object);
        List<String> value = new ArrayList<>();
        value.add(word);
        value.add(definition);
        return value;
    }
}

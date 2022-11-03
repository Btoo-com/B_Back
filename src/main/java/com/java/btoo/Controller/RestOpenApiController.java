package com.java.btoo.Controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
@CrossOrigin
@Controller
public class RestOpenApiController {

    @GetMapping("api")
    @ResponseBody
    public String CallApiWithJson(@Param("search")String search) {
        StringBuffer result = new StringBuffer();
        String jsonresult = null;
        try {
            String apiUrl = "http://opendict.korean.go.kr/api/search?key=40CE4561578F58427CE6A3292B3322C0&req_type=json&q="+search;
            URL url = new URL(apiUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
            String returnLine;
            while ((returnLine = bufferedReader.readLine()) != null) {
                result.append(returnLine);
            }
            jsonresult = result.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonresult;


    }
}

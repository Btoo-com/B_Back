package com.java.btoo.Service;

import lombok.NoArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@NoArgsConstructor
@Service
public class OpenAPIService {
    @Transactional
    public JSONObject getJSON(String search){
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

        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONParser parser = new JSONParser();
        JSONObject object = null;
        try {
            object = (JSONObject) parser.parse(String.valueOf(result));
        }catch (ParseException e){
            e.printStackTrace();
        }
        return object;
    }

    @Transactional
    public JSONObject OneParsing(JSONObject object){
        JSONObject head = (JSONObject) object.get("channel");
        JSONArray jsonArray = (JSONArray) head.get("item");
        JSONObject zeroIndex = (JSONObject)jsonArray.get(0);
        return zeroIndex;
    }
    @Transactional
    public String GetWord(JSONObject object){
        return (String) object.get("word");
    }
    @Transactional
    public String getDefinition(JSONObject object){
        JSONArray jsonArray = (JSONArray) object.get("sense");
        JSONObject sense = (JSONObject) jsonArray.get(0);
        String definition = (String) sense.get("definition");
        return definition;
    }
}

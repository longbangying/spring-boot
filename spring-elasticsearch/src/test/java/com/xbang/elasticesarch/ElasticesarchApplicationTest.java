package com.xbang.elasticesarch;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class ElasticesarchApplicationTest {

    @Autowired
    private RestClient restClient;


    @Test
    public void testClient (){
        /*try {
            *//*Request request = new Request("get","/");
//            request.addParameter("");
            Response response = restClient.performRequest(request);
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);*//*
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }



    @Test
    public void  addDoc() {
        try {
            String uuid = UUID.randomUUID().toString();
            Map  map = new HashMap();
            map.put("title","麻江是贵州的一个县");

            boolean flag = insertDoc(map,"test","1");
            log.info("结果:{}",flag);

        } catch (Exception e) {
            log.error("error:{}",e.getMessage());
        }
    }


    private boolean insertDoc(Map map,String index,String type){
        if (null == map || map.isEmpty() || StringUtils.isEmpty(index) || StringUtils.isEmpty(type)) {
            log.info("invalidate param");
            return false;
        }
        try {
            Request request = new Request("post",new StringBuilder("/").append(index).append("/").append(type).toString());
            request.addParameter("pretty","true");
            JSONObject jsonObject = new JSONObject(map);
            request.setJsonEntity(jsonObject.toString());
            Response response = this.restClient.performRequest(request);
            String result = EntityUtils.toString(response.getEntity());
            JSONObject jsonObject1 = new JSONObject(result);
            if("created".equals(jsonObject1.getString("result"))){
                return true;
            }
        } catch (Exception e) {
            log.error("error:{}",e.getMessage());
        }
        return false;
    }

    @Test
    public void getDoc(){
        try {
            String id = "H-vEem8Bv8rEsavODrTw";//"76eb7f15fe88489db57c5299198b6818";
            String query = "{\"query\":{\"match_phrase\":{\"title\":\"中国\"}}}";
            Request request = new Request("post",new StringBuilder("/test").append("/_search").toString());
            request.addParameter("pretty","true");
            request.setJsonEntity(query);
            Response response = this.restClient.performRequest(request);
            String result = EntityUtils.toString(response.getEntity());
            log.info(result);
        } catch (IOException e) {
            log.error("error:{}", e.getMessage());

        }
    }



}

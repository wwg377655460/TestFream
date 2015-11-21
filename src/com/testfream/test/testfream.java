package com.testfream.test;

import com.alibaba.fastjson.JSONObject;
import com.testfream.core.MyJsonObject;
import com.testfream.core.Response;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.testfream.core.TestFream.*;

/**
 * Created by wsdevotion on 15/11/21.
 */
public class testfream {

    @BeforeClass
    public static void setup(){
        init("http://localhost", "", "RestfulApi/index.php/");
//        initFile();
    }

//    @Test
//    public void test(){
//
//        get("http://localhost/RestfulApi/index.php/api/users", "", (request -> {
//            Map<String, String> map = new HashMap<String, String>();
//            map.put("name", "wer123");
//            map.put("phone", "121");
//            request.setParameters(map);
//            Response response = request.send_param();
////            System.out.println(response.getContent());
//            return response;
//        })).getJson().except().equalStr("name", "0");
//
////        response
//    }

//    @Test
//    public void test1(){
//
//        post("http://localhost/RestfulApi/index.php/api/users", "",  (request -> {
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("name", "wersdf123");
//            jsonObject.put("sex", 1);
//            jsonObject.put("group_name", 1);
//            jsonObject.put("imgurl", "www.123.com");
//            jsonObject.put("phone", "123");
//            jsonObject.put("position", 1);
//            jsonObject.put("code", "296d19ad-d6b1-fa6e-b8d3-0a6abb303257");
//            request.setJson(jsonObject.toString());
//            Response response = request.send_json();
//            System.out.println(response.getContent());
//            return response;
//        }));
//    }

//    @Test
//    public void test2(){
//
//        put("http://localhost/RestfulApi/index.php/api/users", "", (request -> {
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("name", "wersdf123");
//            jsonObject.put("sex", 1);
//            jsonObject.put("group_name", 2);
//            jsonObject.put("imgurl", "www.123.com");
//            jsonObject.put("phone", "123");
//            jsonObject.put("position", 1);
//            request.setJson(jsonObject.toString());
//            Response response = request.send_json();
//            System.out.println(response.getContent());
//            return response;
//        }));
//    }



    @Test
    public void test3(){

        post("/api/sign", "签到", (request -> {
            MyJsonObject myJsonObject = new MyJsonObject();
            myJsonObject.put("name", "wersdf123", "姓名");
            request.setJson(myJsonObject.toString());
            Response response = request.send_json();
            return response;
        })).getJson().except().equalStr("status", "1", "标识符").getJsonArray("data").isArrayNum(2).isArrayKey().equalStr("name", "wer123").equalInt("position", 1).isArrayEnd();


//        createDoc();
    }

//    @Test
//    public void test4(){
//
//        delete("http://localhost/RestfulApi/index.php/api/sign", "",  (request -> {
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("name", "wersdf123");
//            request.setJson(jsonObject.toString());
//            Response response = request.send_json();
//            System.out.println(response.getContent());
//            return response;
//        }));
//    }

//    @Test
//    public void test5(){
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("name", "wersdf123");
//        jsonObject.put("position", "1");
//        System.out.println(jsonObject.getInteger("position"));
//    }

    @Test
    public void test6(){
        get("/Api/getplease", "邀请码", (request -> {
            Response response = request.send_param();
//            System.out.println(response.getContent());
            return response;
        })).getJson().except().equalStr("status", "1").
            getJsonArray("data").isArrayKey().isInt("id").isRegex("num", "[0-9a-zA-Z|-]+").isArrayEnd();


//        createDoc();
//
    }

}

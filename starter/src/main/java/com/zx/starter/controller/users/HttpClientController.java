package com.zx.starter.controller.users;

import com.zx.common.utils.HttpClientUtil;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouxiong
 * @Title: HttpClientController
 * @ProjectName study_lab
 * @Description: TODO
 * @date 2019/7/2614:12
 */
@RestController
@RequestMapping("httpClientTest")
public class HttpClientController {

    @GetMapping("/doGet")
    public void doGetTest(){
        String uri = "http://localhost:8088/user/getUser";
        Map<String,String> parameter = new HashMap<>(1);
        parameter.put("id", "1");
        System.out.println(HttpClientUtil.doGet(uri,parameter));

        String url = "http://localhost:8088/user/getAll";
        System.out.println(HttpClientUtil.doGet(url));
    }

    @GetMapping("/doPost")
    public void doPostTest(){
        String uri = "http://localhost:8088/user/addUser";
        Map<String,String> parameter = new HashMap<>(2);
        parameter.put("username", "小明");
        parameter.put("password", "123asd");
        System.out.println(HttpClientUtil.doPost(uri, parameter));
    }

}

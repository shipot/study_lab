package com.zx.starter.controller.users;

import com.zx.common.utils.HttpClientUtil;
import com.zx.domain.po.users.Users;
import com.zx.service.core.users.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/user")
public class UsersController {
    @Resource
    private UsersService usersService;

    @RequestMapping("/getUser")
    public Users getUser(Integer id){
        String uri = "http://172.16.1.128:8088/user/getAgain";
        Map<String,String> parameter = new HashMap<>(1);
        parameter.put("id", "2");
        System.out.println(HttpClientUtil.doGet(uri,parameter));
        return usersService.selectAll(id);
    }

    @RequestMapping("/getAgain")
    public Users getAgain(Integer id){
        return usersService.selectAll(id);
    }



}

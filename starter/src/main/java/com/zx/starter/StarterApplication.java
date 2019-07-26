package com.zx.starter;

import com.alibaba.fastjson.JSON;
import com.zx.domain.po.users.Users;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@Slf4j
@SpringBootApplication
@ComponentScan(basePackages = {"com.zx"})
@MapperScan(basePackages = "com.zx.dao.mapper")
public class StarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarterApplication.class, args);
        //System.out.println(serialize());
        //System.out.println(deuserialize());

    }

    public static String serialize(){
        Users users = new Users();
        users.setId(1L);
        users.setUsername("小爱");
        users.setPassword("123asd");
        String jsonString = JSON.toJSONString(users);
        return jsonString;
    }

    public static Object deuserialize(){
        String s =serialize();
        return JSON.parseObject(s, Users.class);
    }

}

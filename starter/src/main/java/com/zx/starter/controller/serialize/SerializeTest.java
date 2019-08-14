package com.zx.starter.controller.serialize;

import com.alibaba.fastjson.JSON;
import com.zx.domain.po.users.Users;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zhouxiong
 * @Title: SerializeTest
 * @ProjectName study_lab
 * @Description: TODO
 * @date 2019/8/1414:00
 */

@ComponentScan(basePackages = {"com.zx"})
@MapperScan(basePackages = "com.zx.dao.mapper")
public class SerializeTest {

    public static void main(String[] args) {
        System.out.println(serialize());
        System.out.println(deuserialize());

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

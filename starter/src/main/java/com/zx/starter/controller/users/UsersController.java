package com.zx.starter.controller.users;

import com.zx.domain.po.users.Users;
import com.zx.service.core.users.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/user")
public class UsersController {
    @Resource
    private UsersService usersService;

    @RequestMapping("/getUser")
    public Users getUser(Integer id){
        return usersService.selectAll(id);
    }
}

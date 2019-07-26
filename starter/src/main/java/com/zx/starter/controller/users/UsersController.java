package com.zx.starter.controller.users;

import com.zx.domain.po.users.Users;
import com.zx.service.core.users.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UsersController {
    @Resource
    private UsersService usersService;

    @GetMapping("/getAll")
    public List<Users> selectAll(){
        return usersService.selectAll();
    }

    @GetMapping("/getUser")
    public Users getUser(Integer id){
        return usersService.selectById(id);
    }

    @PostMapping("/addUser")
    public Boolean addUser(@RequestBody Users users){
        int b = usersService.addUser(users);
        if (b!=1)
            return false;
        return true;
    }



}

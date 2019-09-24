package com.zx.starter.controller.user;

import com.zx.domain.po.users.Users;
import com.zx.service.core.users.UsersService;
import com.zx.starter.controller.aspect.AspectTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @author zhouxiong
 * @Title: UsersController
 * @ProjectName study_lab
 * @Description: TODO
 * @date 2019/8/1513:50
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UsersController {

    @Resource
    private UsersService usersService;

    @GetMapping("/getAll")
    public Future<List<Users>> selectAll(){
        CompletableFuture<List<Users>> futurePrice = new CompletableFuture<>();
        new Thread(()->{
            futurePrice.complete(usersService.selectAll());
        }).start();
        return futurePrice;

    }

    @AspectTest
    @GetMapping("/getUser")
    public Users getUser(Integer id){
        Users users = usersService.selectById(id);
        return users;
    }

    @PostMapping("/addUser")
    public int addUser(@RequestBody Users users){
        return  usersService.addUser(users);
    }

    @GetMapping("/getList")
    public  List<Map<String,Object>> getList(){
        return usersService.selectMap();
    }


}

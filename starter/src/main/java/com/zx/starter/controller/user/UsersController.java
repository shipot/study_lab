package com.zx.starter.controller.user;

import com.zx.domain.po.users.Users;
import com.zx.service.core.users.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return b==1?true:false;
    }

    @GetMapping("/getList")
    public  List<Map<String,Object>> getList(){

        return usersService.selectMap();
    }

    @GetMapping("/test")
    public Map<String,Integer> test(){

        Map<String,Integer> map = new HashMap<>();
        map.put("sdasd", 1);
        map.put("dasda", 2);
        return map;

    }



}

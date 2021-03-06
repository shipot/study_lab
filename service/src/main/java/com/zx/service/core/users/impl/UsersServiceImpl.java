package com.zx.service.core.users.impl;

import com.zx.dao.mapper.users.UsersMapper;
import com.zx.domain.po.users.Users;
import com.zx.service.core.users.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@Service
public class UsersServiceImpl implements UsersService {

    @Resource
    private UsersMapper usersMapper;

    @Override
    public List<Users> selectAll() {
        return usersMapper.selectAll();
    }

    @Override
    public Users selectById(Integer id) {
        Users users = usersMapper.selectById(id);
        return users;
    }

    @Override
    public int addUser(Users users) {
        return usersMapper.insert(users);
    }

    @Override
    public List<Map<String, Object>> selectMap() {
        List<Map<String, Object>> list = usersMapper.selectMap();
        System.out.println(list);
        return list;
    }
}

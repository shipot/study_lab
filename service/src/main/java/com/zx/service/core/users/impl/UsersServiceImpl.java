package com.zx.service.core.users.impl;

import com.zx.dao.mapper.users.UsersMapper;
import com.zx.domain.po.users.Users;
import com.zx.service.core.users.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UsersServiceImpl implements UsersService {

    @Resource
    private UsersMapper usersMapper;
    @Override
    public Users selectAll(Integer id) {
        Users users = usersMapper.selectAll(id);
        return users;
    }
}

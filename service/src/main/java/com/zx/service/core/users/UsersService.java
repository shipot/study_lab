package com.zx.service.core.users;

import com.zx.domain.po.users.Users;

import java.util.List;
import java.util.Map;

public interface UsersService {

  List<Users> selectAll();

  Users selectById(Integer id);

  int addUser(Users users);

  List<Map<String,Object>> selectMap();

}

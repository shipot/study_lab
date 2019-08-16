package com.zx.dao.mapper.users;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zx.domain.po.users.Users;

import java.util.List;
import java.util.Map;

public interface UsersMapper extends BaseMapper<Users> {

    List<Users> selectAll();

    List<Map<String,Object>> selectMap();

}

package com.zx.domain.po.users;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("users")
public class Users {
    
    @TableId(type = IdType.AUTO)
    private Long id;

    private String username;

    private String password;

    private String time;

    private Date createTime;

    private Date updateTime;
}

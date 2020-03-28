package com.xbang.mybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("t_user_info")
public class UserInfo implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private long id;

    private String userName;

    public static  UserInfo create(String userName){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userName);
        return userInfo;
    }
}

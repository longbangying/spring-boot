package com.xbang.mybatis.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class TTestInfo {
    @TableId(value = "id",type = IdType.AUTO)
    private long id;
    @TableField("name_")
    private String name;
}

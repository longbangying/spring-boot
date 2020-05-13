package com.xbang.mybatis.entity;

import lombok.Data;
import lombok.ToString;

import java.util.List;
@Data
@ToString
public class UserFullInfo {

    private String userName;

    private List<RoleInfo> roleList;




}

package com.xbang.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xbang.mybatis.entity.RoleInfo;
import com.xbang.mybatis.entity.UserFullInfo;
import com.xbang.mybatis.entity.UserInfo;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserInfoMapper extends BaseMapper<UserInfo> {

    UserFullInfo testCollection();
    @MapKey("roleCode")
    Map<String, List<RoleInfo>> queryRoleInfo();
    @Select("select * from t_user_info where id =#{id}")
    Map selectUserInfo(@Param("id") String id);

}

package com.xbang.jta.service.impl;

import com.xbang.jta.dao.entity.UserInfo;
import com.xbang.jta.dao.mapper.db2.UserInfoDb2Mapper;
import com.xbang.jta.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2020-11-13
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDb2Mapper, UserInfo> implements IUserInfoService {

}

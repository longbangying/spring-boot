package com.xbang.db.service.impl;

import com.xbang.db.dao.entity.UserInfo;
import com.xbang.db.dao.mapper.UserInfoMapper;
import com.xbang.db.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2020-10-26
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}

package com.xbang.mybatis.service.face;

import com.xbang.commons.vo.result.Result;
import com.xbang.mybatis.dao.entity.TUserInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xbang
 * @since 2019-12-31
 */
public interface ITUserInfoService extends IService<TUserInfo> {
    Result addUser(TUserInfo tUserInfo);

    Result userPage();
}

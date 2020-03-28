package com.xbang.mybatis.service.face;

import com.xbang.commons.vo.result.Result;
import com.xbang.mybatis.dao.entity.TRoleInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.management.relation.RoleInfo;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xbang
 * @since 2019-12-30
 */
public interface ITRoleInfoService extends IService<TRoleInfo> {
    Result addRoleInfo(TRoleInfo tRoleInfo);

    Result queryRoleInfo(long roleId);

    Result queryRoleInfoByPage(TRoleInfo tRoleInfo);


    List<TRoleInfo> queryRoleInfoList(TRoleInfo tRoleInfo);
}

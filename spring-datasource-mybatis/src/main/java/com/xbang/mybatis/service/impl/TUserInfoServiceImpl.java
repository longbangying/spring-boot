package com.xbang.mybatis.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.xbang.commons.result.BaseResult;
import com.xbang.commons.result.Result;
import com.xbang.commons.result.ResultEnum;
import com.xbang.mybatis.dao.entity.TUserInfo;
import com.xbang.mybatis.dao.mapper.TUserInfoMapper;
import com.xbang.mybatis.service.face.ITUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xbang
 * @since 2019-12-31
 */
@Slf4j
@Service
public class TUserInfoServiceImpl extends ServiceImpl<TUserInfoMapper, TUserInfo> implements ITUserInfoService {
    @DS("master")
    @Override
    public Result addUser(TUserInfo tUserInfo) {
        boolean flag = this.save(tUserInfo);
        return flag ? BaseResult.getResult(ResultEnum.SUCCESS,"") : BaseResult.getResult(ResultEnum.FAIL,"");
    }

    @DS("slave")
    @Override
    public Result userPage() {
        List<TUserInfo> userInfoList = this.lambdaQuery().last("limit 50").list();
        return BaseResult.getResult(ResultEnum.SUCCESS, userInfoList);
    }
}

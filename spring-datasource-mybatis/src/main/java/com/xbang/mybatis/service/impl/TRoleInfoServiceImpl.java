package com.xbang.mybatis.service.impl;

import com.xbang.commons.result.BaseResult;
import com.xbang.commons.result.Result;
import com.xbang.commons.result.ResultEnum;
import com.xbang.mybatis.dao.entity.TRoleInfo;
import com.xbang.mybatis.dao.mapper.TRoleInfoMapper;
import com.xbang.mybatis.service.face.ITRoleInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xbang
 * @since 2019-12-30
 */
@Service
public class TRoleInfoServiceImpl extends ServiceImpl<TRoleInfoMapper, TRoleInfo> implements ITRoleInfoService {

    @Transactional
    @Override
    public Result addRoleInfo(TRoleInfo tRoleInfo) {
        if(null == tRoleInfo){
            return BaseResult.getResult(ResultEnum.FAIL,"参数错误");
        }
        checkArgs(tRoleInfo);
        boolean result = this.save(tRoleInfo);
        if (result) {
            return BaseResult.getResult(ResultEnum.SUCCESS, "");
        }
        return BaseResult.getResult(ResultEnum.FAIL,"");
    }

    @Override
    public Result queryRoleInfo(long roleId) {
        TRoleInfo tRoleInfo = this.getById(roleId);

        return BaseResult.getResult(ResultEnum.SUCCESS,tRoleInfo);
    }

    @Override
    public Result queryRoleInfoByPage(TRoleInfo tRoleInfo) {
        return BaseResult.getResult(ResultEnum.SUCCESS,queryRoleInfoList(tRoleInfo));
    }


    private void checkArgs(TRoleInfo tRoleInfo){
        if( null == tRoleInfo){
            return ;
        }
        TRoleInfo tRoleInfo1 = new TRoleInfo();
        tRoleInfo1.setRoleName(tRoleInfo.getRoleName());
        List<TRoleInfo> list = queryRoleInfoList(tRoleInfo1);
        if(null != list && !list.isEmpty()){
            throw  new RuntimeException("");
        }
    }

    @Override
    public List<TRoleInfo> queryRoleInfoList(TRoleInfo tRoleInfo) {
       /* LambdaQueryChainWrapper<TRoleInfo> lambdaQueryChainWrapper = this.lambdaQuery();
        if(null == tRoleInfo){
            return lambdaQueryChainWrapper.last("limit 10").list();
        }

        if(null != tRoleInfo && StringUtils.isNotBlank(tRoleInfo.getRoleName())){
            lambdaQueryChainWrapper.eq(TRoleInfo::getRoleName,tRoleInfo.getRoleName());
        }
        if(null != tRoleInfo && StringUtils.isNotBlank(tRoleInfo.getRoleCode())){
            lambdaQueryChainWrapper.eq(TRoleInfo::getRoleCode,tRoleInfo.getRoleCode());
        }
        return lambdaQueryChainWrapper.last("limit 20").list();*/
       return null;
    }
}

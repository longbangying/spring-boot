package com.xbang.db.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.xbang.db.dao.entity.PmsProduct;
import com.xbang.db.dao.mapper.PmsProductMapper;
import com.xbang.db.service.IPmsProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品信息 服务实现类
 * </p>
 *
 * @author admin
 * @since 2020-10-26
 */
@Service
public class PmsProductServiceImpl extends ServiceImpl<PmsProductMapper, PmsProduct> implements IPmsProductService {
    @Override
    public List<PmsProduct> productList(PmsProduct pmsProduct, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        LambdaQueryChainWrapper<PmsProduct> lambdaQueryChainWrapper = this.lambdaQuery();
        if(null == pmsProduct){
            return this.list();
        }
        if(null != pmsProduct.getPublishStatus()){
            lambdaQueryChainWrapper.ge(PmsProduct::getPublishStatus,pmsProduct.getPublishStatus());
        }
        if(null != pmsProduct.getVerifyStatus()){
            lambdaQueryChainWrapper.ge(PmsProduct::getVerifyStatus,pmsProduct.getVerifyStatus());
        }
        if(StringUtils.isNotBlank(pmsProduct.getKeywords())){
            lambdaQueryChainWrapper.like(PmsProduct::getName,pmsProduct.getKeywords());
        }
        if(StringUtils.isNotBlank(pmsProduct.getProductSn())){
            lambdaQueryChainWrapper.eq(PmsProduct::getProductSn,pmsProduct.getProductSn());
        }
        if(null != pmsProduct.getBrandId()){
            lambdaQueryChainWrapper.eq(PmsProduct::getBrandId,pmsProduct.getBrandId());
        }
        if(null != pmsProduct.getProductCategoryId()){
            lambdaQueryChainWrapper.eq(PmsProduct::getProductCategoryId,pmsProduct.getProductCategoryId());
        }
        return lambdaQueryChainWrapper.list();
    }
}

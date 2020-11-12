package com.xbang.db.service;

import com.xbang.db.dao.entity.PmsProduct;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商品信息 服务类
 * </p>
 *
 * @author admin
 * @since 2020-10-26
 */
public interface IPmsProductService extends IService<PmsProduct> {
    /**
     * 商品列表
     * @param pmsProduct
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<PmsProduct> productList(PmsProduct pmsProduct, Integer pageSize, Integer pageNum);
}

package com.xbang.db.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xbang.db.dao.entity.PmsProduct;
import com.xbang.db.service.IPmsProductService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/**
 * Description
 *
 * @author admin
 * @version: 1.0
 * create date: 2020/10/26
 * update date: 2020/10/26
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PmsProductServiceImplTest {
    @Autowired
    IPmsProductService iPmsProductService;
    @Test
    public void productList() {

        //List<PmsProduct> pmsProductList = iPmsProductService.productList(null,10,1);

        //pmsProductList.forEach(System.out::println);

        List<PmsProduct> pmsProductList = iPmsProductService.lambdaQuery()
                .eq(PmsProduct::getDeleteStatus,0)
                .nested(item->item.like(PmsProduct::getBrandName,"1").or().like(PmsProduct::getName,"2")).list();

        pmsProductList.forEach(System.out::println);
    }
}

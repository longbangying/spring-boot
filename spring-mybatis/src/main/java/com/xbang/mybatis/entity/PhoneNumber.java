package com.xbang.mybatis.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author admin
 * @date 2020/5/14
 */
@Data
@ToString
@NoArgsConstructor
public class PhoneNumber {

    private long id;

    /**
     * 号码
     */
    private String phoneNumber;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 包含的话费
     */
    private BigDecimal telephoneCharge;

    private Integer channelNo;

    private String thirdParty;

    private Integer isp;

    private Integer areaId;

    private Integer dataState;

    private Integer phoneState;

    private Date dateCreated;

    private String createdBy;

    private Date dateUpdated;

    private String updatedBy;
}

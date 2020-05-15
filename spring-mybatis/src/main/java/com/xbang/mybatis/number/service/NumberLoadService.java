package com.xbang.mybatis.number.service;

/**
 * @author admin
 * @date 2020/5/14
 */
public interface NumberLoadService {
    /**
     * 加载号码
     */
    void loadNumber();

    /**
     * 区域Id
     * @return
     */
    Integer getAreaId();

    /**
     * 运营商 1-移动 2-联通 3-电信
     * @return
     */
    Integer getIsp();

    /**
     * 渠道ID
     * @return
     */
    Integer getChannelNo();
}

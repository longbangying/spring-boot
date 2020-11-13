package com.xbang.commons.result;

/**
 * Description
 *
 * @author admin
 * @version: 1.0
 * create date: 2020/11/13
 * update date: 2020/11/13
 */
public enum ResultEnum {
    /**
     * 成功
     */
    SUCCESS("0", "success"),
    /**
     * 失败
     */
    FAIL("1", "fail");
    /**
     * 码值
     */
    private String retCode;
    /**
     * 描述信息
     */
    private String retMsg;


    ResultEnum(String retCode, String retMsg) {
        this.retCode = retCode;
        this.retMsg = retMsg;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }}

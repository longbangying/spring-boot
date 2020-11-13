package com.xbang.commons.result;

/**
 * Description
 *
 * @author admin
 * @version: 1.0
 * create date: 2020/11/13
 * update date: 2020/11/13
 */
public class Result {
    /**
     * 码值
     */
    private String retCode;
    /**
     * 描述信息
     */
    private String retMsg;

    public Result(String retCode, String retMsg) {
        this.retCode = retCode;
        this.retMsg = retMsg;
    }

    public Result(ResultEnum resultEnum) {
        this(resultEnum.getRetCode(),resultEnum.getRetMsg());
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
    }

    public static Result success(){
        return new Result(ResultEnum.SUCCESS);
    }

    public static Result fail(){
        return new Result(ResultEnum.FAIL);
    }

    public static Result fail(String message){
        return new Result(ResultEnum.FAIL.getRetCode(),message);
    }

}

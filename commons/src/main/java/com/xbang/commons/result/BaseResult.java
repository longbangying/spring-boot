package com.xbang.commons.result;

/**
 * Description
 *
 * @author admin
 * @version: 1.0
 * create date: 2020/11/13
 * update date: 2020/11/13
 */
public class BaseResult<T> extends Result {
    private T data;
    public BaseResult(ResultEnum resultEnum,T data) {
        super(resultEnum);
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> BaseResult<T> success(T data){
        return new BaseResult(ResultEnum.SUCCESS,data);
    }

    public static <T> BaseResult<T> getResult(ResultEnum resultEnum,T data){
        return new BaseResult(resultEnum,data);
    }
}

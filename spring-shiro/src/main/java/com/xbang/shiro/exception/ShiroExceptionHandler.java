package com.xbang.shiro.exception;

import com.xbang.commons.vo.result.BaseResult;
import com.xbang.commons.vo.result.Result;
import com.xbang.commons.vo.result.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
@Slf4j
@ControllerAdvice
@ResponseBody
public class ShiroExceptionHandler {
    @ExceptionHandler(AuthorizationException.class)
    public Result AuthorizationException(AuthorizationException authorizationException){
        log.info(authorizationException.getMessage());
        return BaseResult.getResult(ResultEnum.RESULT_FAIL,"无权操作.");
    }

}

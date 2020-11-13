package com.xbang.mvc.config;

import com.xbang.commons.result.BaseResult;
import com.xbang.commons.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * ResponseEntityExceptionHandler
 */
@ControllerAdvice
@Component
@Slf4j
public class ExceptionConfig {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Result methodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<ObjectError>  objectErrorList =  exception.getBindingResult().getAllErrors();
        if(CollectionUtils.isEmpty(objectErrorList)){
            return Result.fail();
        }
        StringBuilder failMsg = new StringBuilder();
        for (ObjectError objectError : objectErrorList){
            failMsg.append(objectError.getDefaultMessage());
            failMsg.append(";");
        }
        return Result.fail(failMsg.substring(0,failMsg.length()-1));
    }
}

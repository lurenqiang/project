package com.lurenqiang.sore.utils;

import com.lurenqiang.sore.vo.ResResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Auther: lurenqiang
 * @Date: 2019/11/8
 * @Description: 对输入的参数进行校验
 */
@RestControllerAdvice
public class GlobalDefultExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResResult handleValidationBodyException(MethodArgumentNotValidException e){
        for (ObjectError s : e.getBindingResult().getAllErrors()) {
            return new ResResult("Invalid_Request_Parameter", s.getObjectName() + ": " + s.getDefaultMessage());
        }
        return new ResResult("Invalid_Request_Parameter", "未知参数错误");
    }

}


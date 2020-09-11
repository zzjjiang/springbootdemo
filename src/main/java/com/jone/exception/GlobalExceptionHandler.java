package com.jone.exception;

import com.jone.util.ResultBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zzj
 * @description
 * @date 2020.09.11
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public ResultBody bizExceptionHandler(BizException e){
        logger.info(e.getStackTrace()[0].toString());
        logger.error("发生业务异常！原因是：{}",e.getMessage());
        return ResultBody.error(e.getCode() ,e.getMessage());
    }

    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public ResultBody exceptionHandler(Exception e){
        logger.error("未知异常！原因是:",e);
        return ResultBody.error(e.getMessage());
    }
}

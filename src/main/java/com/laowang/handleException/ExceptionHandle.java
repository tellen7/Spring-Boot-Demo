package com.laowang.handleException;

import com.laowang.dataObject.Result;
import com.laowang.enums.ResultEnums;
import com.laowang.exceptions.UserExceptions;
import com.laowang.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理，是自定义异常则返回固定格式信息，包含错误信息，否则返回未知错误，并打印
 * Created by wangyonghao8 on 2018/3/27.
 */
@ControllerAdvice
public class ExceptionHandle {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class.getName());

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result globalHandle(Exception e){
        if (e instanceof UserExceptions){
            UserExceptions exceptions = (UserExceptions) e;
            return ResultUtils.error(exceptions.getCode(),exceptions.getMessage());
        }else{
            logger.info("未知异常: {}",e);
            return ResultUtils.error(ResultEnums.UNKNOWN_ERROR);
        }
    }
}

package com.laowang.utils;

import com.laowang.dataObject.Result;
import com.laowang.enums.ResultEnums;

/**
 * Created by wangyonghao8 on 2018/3/27.
 */
public class ResultUtils {
    //结果成功的封装
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMessage("success");
        result.setData(object);
        return result;
    }

    //封装成功并返回空
    public static Result success(){
        return success(null);
    }

    //封装失败，data为空
    public static Result error(Integer code,String message){
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        result.setData(null);
        return result;
    }

    public static Result error(ResultEnums enums){
        Result result = new Result();
        result.setCode(enums.getCode());
        result.setMessage(enums.getMessage());
        result.setData(null);
        return result;
    }
}

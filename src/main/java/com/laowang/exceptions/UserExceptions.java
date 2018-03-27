package com.laowang.exceptions;

import com.laowang.enums.ResultEnums;

/**
 * Created by wangyonghao8 on 2018/3/27.
 */
public class UserExceptions extends RuntimeException {
    private Integer code;

    //统一处理异常信息
//    public UserExceptions(Integer code,String message){
//        super(message);
//        this.setCode(code);
//    }

    public UserExceptions(ResultEnums resultEnums){
        super(resultEnums.getMessage());
        this.setCode(resultEnums.getCode());
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

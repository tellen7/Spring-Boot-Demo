package com.laowang.enums;

/**
 * Created by wangyonghao8 on 2018/3/27.
 */
public enum ResultEnums {
    SUCCESS(0,"成功"),
    UNKNOWN_ERROR(-1,"未知错误"),
    TOO_YOUNG(100,"太年轻了，不给你借钱"),
    GOOD_AGE(99,"我可以借钱给你")
    ;

    private Integer code;
    private String message;

    ResultEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

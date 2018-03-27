package com.laowang.dataObject;

/**
 * Created by wangyonghao8 on 2018/3/27.
 */
//http返回请求的最外层对象,用于统一返回数据格式
public class Result<T> {
    //错误码
    private Integer code;
    //返回的信息
    private String message;
    //返回的数据对象
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}

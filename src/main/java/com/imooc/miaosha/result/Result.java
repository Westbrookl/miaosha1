package com.imooc.miaosha.result;

import lombok.Getter;
import lombok.Setter;

/**
 * @author jhc on 2019/2/25
 */
@Getter
@Setter
public class Result<T> {
    private T data;
    private String msg;
    private int code;

    public static <T> Result<T> success(T data){
        return new Result<T>(data);
    }
    public static <T> Result<T> error(CodeMsg codeMsg){
        return new Result<T>(codeMsg);
    }

    private Result (T data){
        this.code = 0;
        this.msg = "success";
        this.data = data;
    }
    private Result(CodeMsg codeMsg){
        if(codeMsg == null){
            return;
        }
        this.code = codeMsg.getCode();
        this.msg = codeMsg.getMsg();
    }
}

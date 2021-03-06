package com.imooc.miaosha.result;

import lombok.Getter;
import lombok.Setter;

/**
 * @author jhc on 2019/2/25
 */
@Getter
@Setter
public class CodeMsg {
    private int code;
    private String msg;
    //通用异常
    public static CodeMsg SUCCESS = new CodeMsg(0, "success");
    public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务端异常");
    public static CodeMsg BIND_ERROR = new CodeMsg(500101, "参数校验异常：%s");
    ///5是登录异常
    public static CodeMsg SESSION_ERROR = new CodeMsg(500210, "Session不存在或者已经失效");
    public static CodeMsg PASSWORD_EMPTY = new CodeMsg(500211, "登录密码不能为空");
    public static CodeMsg MOBILE_EMPTY = new CodeMsg(500212, "手机号不能为空");
    public static CodeMsg MOBILE_ERROR = new CodeMsg(500213, "手机号格式错误");
    public static CodeMsg MOBILE_NOT_EXIST = new CodeMsg(500214, "手机号不存在");
    public static CodeMsg PASSWORD_ERROR = new CodeMsg(500215, "密码错误");
    ///秒杀模块 505XX
    public static CodeMsg MIAO_SHA_OVER = new CodeMsg(50500, "秒杀已经完毕");
    public static CodeMsg REPEAT_MIAO_SHA = new CodeMsg(50501, "不能重复秒杀");

    public CodeMsg(int code1, String ms1) {
        this.code = code1;
        this.msg = ms1;
    }

    public CodeMsg fillArgs(Object... args) {
        int code = this.code;
        String message = String.format(this.msg, args);
        return new CodeMsg(code, message);
    }

    @Override

    public String toString() {
        return msg + ":" + code;
    }

}

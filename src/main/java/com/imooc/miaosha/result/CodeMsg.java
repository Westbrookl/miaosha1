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

    public static CodeMsg SUCCESS = new CodeMsg(0,"success");
    public static CodeMsg ERROR = new CodeMsg(500100,"服务端异常");
    public CodeMsg(int code1,String ms1){
        this.code = code1;
        this.msg = ms1;
    }

}

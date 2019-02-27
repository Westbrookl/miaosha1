package com.imooc.miaosha.exception;

import com.imooc.miaosha.result.CodeMsg;

/**
 * @author jhc on 2019/2/26
 */

public class GlobalException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private CodeMsg cm;

    public GlobalException(CodeMsg cm){
        this.cm = cm;
    }
    public CodeMsg getCm(){
        return  cm;
    }
}

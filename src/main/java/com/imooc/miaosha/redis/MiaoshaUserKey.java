package com.imooc.miaosha.redis;

/**
 * @author jhc on 2019/2/26
 */
public class MiaoshaUserKey  extends BasePrefix{

    private final static int TOKEN_EXPIRE = 60*60*24*2;
    private MiaoshaUserKey(int expireSeconds,String prefix){
        super(expireSeconds,prefix);
    }
    public static MiaoshaUserKey token = new MiaoshaUserKey(TOKEN_EXPIRE,"token");
}

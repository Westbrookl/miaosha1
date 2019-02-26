package com.imooc.miaosha.redis;

/**
 * @author jhc on 2019/2/25
 */
public class UserKey extends BasePrefix {
    private UserKey(String prefix){
        super(prefix);
    }
    private UserKey(String prefix,int expireTime){
        super(expireTime,prefix);
    }
    public static UserKey getById = new UserKey("id");
    public static UserKey  getByName = new UserKey("name");
}

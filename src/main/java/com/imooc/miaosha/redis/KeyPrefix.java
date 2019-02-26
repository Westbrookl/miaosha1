package com.imooc.miaosha.redis;

/**
 * @author jhc on 2019/2/25
 */
public interface KeyPrefix {
    public int expireSeconds();
    public String  getPrefix();
}

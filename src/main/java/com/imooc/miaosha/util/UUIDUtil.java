package com.imooc.miaosha.util;

import java.util.UUID;

/**
 * @author jhc on 2019/2/26
 */
public class UUIDUtil {
    public static String uuid(){
        return UUID.randomUUID().toString().replace("-","");
    }
}

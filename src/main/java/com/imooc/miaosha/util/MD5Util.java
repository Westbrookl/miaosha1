package com.imooc.miaosha.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author jhc on 2019/2/26
 */
public class MD5Util {
    public static String md5(String str){
        return DigestUtils.md5Hex(str);
    }
    private final static String SALT = "1a2b3c4d";

    public static String inputPassToFormPass(String inputPass){
        String str = "" + SALT.charAt(0)+SALT.charAt(2)+inputPass+SALT.charAt(5)+SALT.charAt(4);
        return  md5(str);
    }

    public static String formPassToDBPass(String formPass,String salt){
        String str = "" + SALT.charAt(0)+SALT.charAt(2)+formPass+SALT.charAt(5)+SALT.charAt(4);
        return md5(str);
    }
    public static String inputPassToDBPass(String inputPass,String salt){
        String str1 = inputPassToFormPass(inputPass);
        String str2 = formPassToDBPass(str1,salt);
        return str2;
    }
    public static void main(String[] args){
        String s1 = "123456";
        System.out.println(inputPassToDBPass(s1,"1a2b3c4d"));
    }
}

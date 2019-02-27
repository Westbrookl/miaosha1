package com.imooc.miaosha.util;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author jhc on 2019/2/26
 */
public class ValidatorUtil {

//    private Pattern patter = Pattern.compile("1\\d{10}");
    private static final Pattern pattern = Pattern.compile("1\\d{10}");

    public static boolean isMobile(String str){
        if(StringUtils.isEmpty(str)){
            return  false;
        }
        Matcher matcher =  pattern.matcher(str);
        return matcher.matches();
    }
//    public static void main(String[] args){
//        System.out.println(isMobile("13831845038"));
//        System.out.println(isMobile("1383184503"));
//    }
}

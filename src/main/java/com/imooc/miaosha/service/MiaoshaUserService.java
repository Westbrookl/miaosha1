package com.imooc.miaosha.service;

import com.imooc.miaosha.dao.MiaoshaUserDao;
import com.imooc.miaosha.domain.MiaoshaUser;
import com.imooc.miaosha.exception.GlobalException;
import com.imooc.miaosha.redis.MiaoshaUserKey;
import com.imooc.miaosha.redis.RedisService;
import com.imooc.miaosha.result.CodeMsg;
import com.imooc.miaosha.result.Result;
import com.imooc.miaosha.util.MD5Util;
import com.imooc.miaosha.util.UUIDUtil;
import com.imooc.miaosha.vo.LoginVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author jhc on 2019/2/26
 */
@Service
public class MiaoshaUserService {
    public  static String COOKIE_NAME_TOKEN = "token";

    @Autowired
    MiaoshaUserDao miaoshaUserDao;
    @Resource
    RedisService redisService;

    public MiaoshaUser getUserByToken(HttpServletResponse response,String token){
        if(StringUtils.isEmpty(token)){
            return  null;
        }
        MiaoshaUser user=  redisService.get(MiaoshaUserKey.token,token,MiaoshaUser.class);
        //延长有效期，也就是更新token的时间
        if(user != null){
            addCookie(response,token,user);
        }
        return user;
    }

    public MiaoshaUser getById(long id){
        return miaoshaUserDao.getById(id);
    }
    public String login(HttpServletResponse response,LoginVo loginVo){
        if(loginVo == null){
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        long id = loginVo.getMobile();
        String password = loginVo.getPassword();
        MiaoshaUser user = getById(id);
        if(user == null){
            throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
        }
        String DBPass  = user.getPassword();
        String salt = user.getSalt();
        String newPass = MD5Util.formPassToDBPass(password,salt);
        if(!DBPass.equals(newPass)){
           throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }
        String token = UUIDUtil.uuid();
        addCookie(response,token,user);
        return token;
    }
    public void addCookie(HttpServletResponse response,String token,MiaoshaUser user){
        redisService.set(MiaoshaUserKey.token,token,user);
        Cookie cookie = new Cookie(COOKIE_NAME_TOKEN,token);
        cookie.setMaxAge(MiaoshaUserKey.token.expireSeconds());
        cookie.setPath("/");
        response.addCookie(cookie);

    }

}

package com.imooc.miaosha.Controller;

import com.imooc.miaosha.domain.MiaoshaUser;
import com.imooc.miaosha.redis.MiaoshaUserKey;
import com.imooc.miaosha.redis.RedisService;
import com.imooc.miaosha.service.MiaoshaUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author jhc on 2019/2/26
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Resource
    RedisService redisService;
    @Resource
    MiaoshaUserService miaoshaUserService;

//    @RequestMapping("/to_list")
//    public String list(HttpServletRequest request, Model model){
//        Cookie[] cookie1 = request.getCookies();
//        Cookie c2 = null;
//        for(Cookie c1 : cookie1){
//            if( c1.getName().equals("token")){
//                c2 = c1;
//            }
//        }
//        String token = c2.getValue();
//        MiaoshaUser user = redisService.get(MiaoshaUserKey.token,token,MiaoshaUser.class);
//        model.addAttribute("user",user);
//        return "goods_list";
//    }

    /**
     * 这样user便可以通过我们的Spring框架自动的为MiaoshaUser这个类赋值。
     * @param user
     * @param model
     * @return
     */
    @RequestMapping("/to_list")
    public  String toList(MiaoshaUser user,Model model){
        model.addAttribute("user",user);
        return "goods_list";
    }
}

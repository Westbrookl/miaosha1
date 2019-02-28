package com.imooc.miaosha.Controller;

import com.imooc.miaosha.domain.MiaoshaUser;
import com.imooc.miaosha.redis.MiaoshaUserKey;
import com.imooc.miaosha.redis.RedisService;
import com.imooc.miaosha.service.GoodsService;
import com.imooc.miaosha.service.MiaoshaUserService;
import com.imooc.miaosha.vo.GoodsVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    @Resource
    GoodsService goodsService;

    /**
     * 这样user便可以通过我们的Spring框架自动的为MiaoshaUser这个类赋值。
     * @param user
     * @param model
     * @return
     */
    @RequestMapping("/to_list")
    public  String toList(MiaoshaUser user,Model model){

        model.addAttribute("user",user);
        List<GoodsVo> goodsList = goodsService.listGoodsVo();
        model.addAttribute("goodsList",goodsList);
        return "goods_list";
    }

    @RequestMapping("/to_detail/{goodsId}")
    public String goodDetail(@PathVariable("goodsId")int goodsId,Model model,MiaoshaUser user){
        model.addAttribute("user",user);
        GoodsVo goodsVo = goodsService.getGoodsVoById(goodsId);
        model.addAttribute("goods",goodsVo);

        long startDate = goodsVo.getStartDate().getTime();
        long endDate = goodsVo.getEndDate().getTime();
        long now = System.currentTimeMillis();
        int status = 0;
        int remainSeconds = 0;
        if(now < startDate){
            status = 0;
            remainSeconds = (int)(startDate-now)/1000;
        }else if( now > endDate){
            status = 2;
            remainSeconds = -1;
        }else{
            status = 1;
            remainSeconds = 0;
        }
        model.addAttribute("miaoshaStatus",status);
        model.addAttribute("remainSeconds",remainSeconds);
        return "goods_detail";
    }
}

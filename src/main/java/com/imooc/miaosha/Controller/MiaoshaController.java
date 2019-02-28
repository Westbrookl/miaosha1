package com.imooc.miaosha.Controller;

import com.imooc.miaosha.domain.MiaoshaOrder;
import com.imooc.miaosha.domain.MiaoshaUser;
import com.imooc.miaosha.domain.OrderInfo;
import com.imooc.miaosha.result.CodeMsg;
import com.imooc.miaosha.service.GoodsService;
import com.imooc.miaosha.service.MiaoshaOrderService;
import com.imooc.miaosha.service.MiaoshaService;
import com.imooc.miaosha.vo.GoodsVo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * @author jhc on 2019/2/27
 */
@Controller
@RequestMapping("/miaosha")
public class MiaoshaController {

    @Resource
    GoodsService goodsService;
    @Resource
    MiaoshaService miaoshaService;
    @Resource
    MiaoshaOrderService miaoshaOrderService;

    /**
     * 这里的逻辑是：
     * 首先判断用户是否登录 没有登录的话那么便去登录
     * 如果登录的话 首先检查库存是否还有 没有的话返回库存结束
     * 如果库存还有就去判断，这个人是否已经下过一次订单。秒杀不允许人重复下单
     * 如果还能执行，就把这个消息写入到数据库当中去。
     * 然后显示订单的消息和商品的消息
     * @param model
     * @param user
     * @param goodsId
     * @return
     */
    @RequestMapping("/do_miaosha")
    public String doMiaosha(Model model, MiaoshaUser user, @RequestParam("goodsId") long goodsId) {
        if (user == null) {
            return "login";
        }
        GoodsVo goodsVo = goodsService.getGoodsVoById(goodsId);
        int count = goodsVo.getStockCount();
        if (count <= 0) {
            model.addAttribute("errmsg", CodeMsg.MIAO_SHA_OVER);
            return "miaosha_fail";
        }
        MiaoshaOrder order = miaoshaOrderService.getByUserIdAndGoodsId(user.getId(), goodsId);
        if (order != null) {
            model.addAttribute("errmsg", CodeMsg.REPEAT_MIAO_SHA);
            return "miaosha_fail";
        }
        //减少库存 下订单 写入数据库
        OrderInfo orderInfo = miaoshaService.miaosha(user, goodsVo);
        model.addAttribute("orderInfo", orderInfo);
        model.addAttribute("goods", goodsVo);
        return "order_detail";
    }
}

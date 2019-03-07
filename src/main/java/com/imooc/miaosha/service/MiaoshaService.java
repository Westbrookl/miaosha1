package com.imooc.miaosha.service;

import com.imooc.miaosha.domain.MiaoshaUser;
import com.imooc.miaosha.domain.OrderInfo;
import com.imooc.miaosha.vo.GoodsVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author jhc on 2019/2/27
 */
@Service
public class MiaoshaService {
    @Resource
    GoodsService goodsService;

    @Resource
    OrderService orderService;

    /**
     * 这里是一个事务，事务的意思就是这两个操作要么都不做，要么都要进行
     * 需要进行的操作是：首先要减少库存，第二是创建出一个订单
     * 创建订单的时候需要写入两个数据库，一个是订单表，一个是秒杀的订单表。
     * @param user
     * @param goodsVo
     * @return
     */
    @Transactional
    public OrderInfo miaosha(MiaoshaUser user, GoodsVo goodsVo){
        goodsService.reduceStock(goodsVo);
        return orderService.createOrder(user,goodsVo);
    }
}

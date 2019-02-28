package com.imooc.miaosha.service;

import com.imooc.miaosha.dao.MiaoshaOrderDao;
import com.imooc.miaosha.domain.MiaoshaOrder;
import com.imooc.miaosha.domain.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jhc on 2019/2/27
 */
@Service
public class MiaoshaOrderService {
    @Autowired
    MiaoshaOrderDao miaoshaOrderDao;

    public MiaoshaOrder getByUserIdAndGoodsId(long userId,long goodsId){
        return  miaoshaOrderDao.getByUserIdAndGoodsId(userId,goodsId);
    }
}

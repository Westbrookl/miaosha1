package com.imooc.miaosha.service;

import com.imooc.miaosha.dao.GoodsDao;
import com.imooc.miaosha.domain.MiaoshaGoods;
import com.imooc.miaosha.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author jhc on 2019/2/27
 */
@Service
public class GoodsService {
    @Autowired
    GoodsDao goodsDao;

    public List<GoodsVo> listGoodsVo(){
        return goodsDao.listGoodsVo();
    }

    public GoodsVo getGoodsVoById(long goodsId){
        return goodsDao.getGoodsVoById(goodsId);
    }

    /**
     * 减少库存直接让库存的数量减一，就可以实现啦
     * @param goodsVo
     */
    public void reduceStock(GoodsVo goodsVo){
        MiaoshaGoods goods = new MiaoshaGoods();
        goods.setGoodsId(goodsVo.getId());//得到商品的Id
        goodsDao.reduceSocket(goods);
    }
}

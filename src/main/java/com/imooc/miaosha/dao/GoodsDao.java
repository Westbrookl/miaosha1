package com.imooc.miaosha.dao;

import com.imooc.miaosha.domain.MiaoshaGoods;
import com.imooc.miaosha.vo.GoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author jhc on 2019/2/27
 */
@Mapper
public interface GoodsDao {
    @Select("select g.*,ms.miaosha_price,ms.stock_count,ms.start_date,ms.end_date from goods as g left join miaosha_goods ms on g.id = ms.goods_id")
    List<GoodsVo> listGoodsVo();
    @Select("select g.*,ms.miaosha_price,ms.stock_count,ms.start_date,ms.end_date from goods as g left join miaosha_goods as ms on g.id = ms.goods_id where g.id = #{id}")
    GoodsVo getGoodsVoById(@Param("id") long id);

    @Update("update miaosha_goods set stock_count = stock_count -1 where goods_id = #{goodsId}")
    int reduceSocket(MiaoshaGoods goods);
}

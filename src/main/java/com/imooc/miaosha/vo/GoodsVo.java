package com.imooc.miaosha.vo;

import com.imooc.miaosha.domain.Goods;
import lombok.Data;

import java.util.Date;

/**
 * @author jhc on 2019/2/27
 */
@Data
public class GoodsVo extends Goods {
    private Double miaoshaPrice;
    private Integer stockCount;
    private Date startDate;
    private Date endDate;
}

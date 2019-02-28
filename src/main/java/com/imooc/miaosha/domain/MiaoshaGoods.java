package com.imooc.miaosha.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author jhc on 2019/2/27
 */
@Data
public class MiaoshaGoods {
    private Long id;
    private Long goodsId;
    private Double miaoshaPrice;
    private Integer stockCount;
    private Date startDate;
    private Date endDate;
}

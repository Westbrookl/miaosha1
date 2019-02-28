package com.imooc.miaosha.domain;

import lombok.Data;

/**
 * @author jhc on 2019/2/27
 */
@Data
public class Goods {
    private Long id;
    private String goodsName;
    private String goodsTitle;
    private String goodsImg;
    private String goodsDetail;
    private Double goodsPrice;
    private Integer goodStock;
}

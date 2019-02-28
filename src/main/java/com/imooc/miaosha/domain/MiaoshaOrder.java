package com.imooc.miaosha.domain;

import lombok.Data;

/**
 * @author jhc on 2019/2/27
 */
@Data
public class MiaoshaOrder {
    private Long id;
    private Long userId;
    private Long orderId;
    private Long goodsId;
}

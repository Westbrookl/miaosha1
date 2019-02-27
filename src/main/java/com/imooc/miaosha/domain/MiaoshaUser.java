package com.imooc.miaosha.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author jhc on 2019/2/26
 * 这个秒杀用户类用来与mysql进行交互。
 */
@Getter
@Setter
public class MiaoshaUser {
    private Long id;
    private String nickname;
    private String password;
    private String salt;
    private String head;
    private Date registerDate;
    private Date loginDate;
    private int loginCount;

}

package com.imooc.miaosha.vo;

import com.imooc.miaosha.validator.IsMobile;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;


/**
 * @author jhc on 2019/2/26
 */
@Data
public class LoginVo {
    @NotNull
    @IsMobile
    private long mobile;

    @Length(min=32)
    @NotNull
    private String password;
}

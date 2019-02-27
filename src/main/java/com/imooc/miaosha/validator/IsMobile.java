package com.imooc.miaosha.validator;

import javax.validation.Constraint;
import java.lang.annotation.*;

/**
 * @author jhc on 2019/2/26
 * required =  true的时候进行校验
 * required=false的时候，如果为空返回true否则接续校验
 */

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {IsMobileValidator.class}
)
public @interface IsMobile {
    boolean required() default true;
    String message() default "{javax.validation.constraints.NotNull.message}";
    Class<?>[] groups() default {};

}

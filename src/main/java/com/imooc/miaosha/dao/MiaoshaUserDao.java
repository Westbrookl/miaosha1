package com.imooc.miaosha.dao;

import com.imooc.miaosha.domain.MiaoshaUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author jhc on 2019/2/26
 */
@Mapper
public interface MiaoshaUserDao {
    @Select("select * from miaosha_user where id =#{id}")
     MiaoshaUser getById(@Param("id")long id);


}

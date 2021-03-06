package com.imooc.miaosha.dao;

import com.imooc.miaosha.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author jhc on 2019/2/25
 */
@Mapper
public interface UserDao {
    @Select("select * from user where id = #{id}")
     User getUserById(@Param("id") int id);

    @Insert("insert into user(id,name)values(#{id},#{name})")
     int insert(User user);
}

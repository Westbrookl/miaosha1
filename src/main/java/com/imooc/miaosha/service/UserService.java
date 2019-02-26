package com.imooc.miaosha.service;

import com.imooc.miaosha.dao.UserDao;
import com.imooc.miaosha.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author jhc on 2019/2/25
 */
@Service
public class UserService {
    @Resource
    UserDao userDao;

    public User getById(int  id){
        return  userDao.getUserById(id);
    }
    public int setUser(User user){
        return userDao.insert(user);
    }

    @Transactional
    public void testTx(){
        User user1 = new User("jihaichuan",3);
        User user = new User("jihaichuan",2);
        userDao.insert(user1);
        userDao.insert(user);
    }

}

package com.imooc.miaosha.Controller;

import com.imooc.miaosha.domain.User;
import com.imooc.miaosha.redis.RedisService;
import com.imooc.miaosha.redis.UserKey;
import com.imooc.miaosha.result.Result;
import com.imooc.miaosha.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author jhc on 2019/2/25
 */
@Controller
@RequestMapping("/demo")
public class SampleController {
    @Resource
    UserService userService;

    @Resource
    RedisService redisService;
    @RequestMapping("/test")
    @ResponseBody
    public Result<String> test(){
        return Result.success("hello Word!");
    }

    @RequestMapping("/hello")
    public String testThy(Model model){
        model.addAttribute("name","jhc");
        return "hello";
    }

    @RequestMapping("/get")
    @ResponseBody
    public Result<User> testGet(){
        User user = userService.getById(1);
        return Result.success(user);
    }
    @RequestMapping("/set")
    @ResponseBody
    public Result<Integer> testSet(){
        User user = new User("jihaichuan",2);
        int te = userService.setUser(user);
        return Result.success(te);
    }
    @RequestMapping("/tx")
    public void testTx(){
        userService.testTx();
    }

    @RequestMapping("/getredis")
    @ResponseBody
    public Result<User> getRedis(){
        User user = new User();
        user.setId(1);
        user.setName("jhc");
        redisService.set(UserKey.getById,"1",user);
        User user1 = redisService.get(UserKey.getById,"1",User.class);
        return Result.success(user1);
    }
}

package com.imooc.miaosha.Controller;

import com.imooc.miaosha.domain.MiaoshaUser;
import com.imooc.miaosha.result.Result;
import com.imooc.miaosha.service.MiaoshaUserService;
import com.imooc.miaosha.vo.LoginVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * @author jhc on 2019/2/26
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    MiaoshaUserService miaoshaUserService;

    @RequestMapping("/to_login")
    public String toLogin(){
        return "login";
    }
    @RequestMapping("/do_login")
    @ResponseBody
    public Result<String> doLogin(HttpServletResponse response,LoginVo loginVo){
        logger.info(loginVo.toString());
       String t =  miaoshaUserService.login(response,loginVo);
       return Result.success(t);
    }
}

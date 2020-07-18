package com.clfeng.controller;

import com.clfeng.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author qian
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("msg", "hello shiro");
        return "index";
    }

    @RequestMapping("user/add")
    public String add() {
        return "user/add";
    }

    @RequestMapping("user/update")
    public String update() {
        return "user/update";
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/login")
    public String login(String username, String password, Model model) {
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //设置记住我
        token.setRememberMe(false);
        //执行登录方法
        try {
            subject.login(token);
            return "index";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg", "用户名错误。");
            return "login";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "密码错误。");
            return "login";
        }
    }

}

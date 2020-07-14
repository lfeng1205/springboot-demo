package com.clfeng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class KungfuController {

    private static final String PREFIX = "views/";

    /**
     * 欢迎页
     *
     * @return
     */
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    /**
     * 登录页
     */
    @GetMapping("/toLogin")
    public String loginPage() {
        return PREFIX + "login";
    }

    /**
     * level1页面映射
     * @param path
     * @return
     */
    @GetMapping("level1/{path}")
    public String level1(@PathVariable("path") String path) {
        return PREFIX + "level1/" + path;
    }

    /**
     * level2页面映射
     * @param path
     * @return
     */
    @GetMapping("level2/{path}")
    public String level2(@PathVariable("path") String path) {
        return PREFIX + "level2/" + path;
    }

    /**
     * level3页面映射
     * @param path
     * @return
     */
    @GetMapping("level3/{path}")
    public String level3(@PathVariable("path") String path) {
        return PREFIX + "level3/" + path;
    }
}

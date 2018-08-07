package com.jykj.easyui.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TODO: 系统登录控制层
 * @author wgbing
 * @date 2018/7/10 15:35
 */
@Controller
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/register")
    public String register() {
        return "/register";
    }

    @GetMapping("/index")
    public String index() {
        return "/index";
    }

    @GetMapping("/main")
    public String welcome() {
        return "/main";
    }

}

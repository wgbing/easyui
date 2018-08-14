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

    /**
     * TODO: 登录
     * @author wgbing
     * @date 2018/8/14 8:50
     */
    @RequestMapping("/login")
    public String login() {
        return "/login";
    }

    /**
     * TODO: 注册
     * @author wgbing
     * @date 2018/8/14 8:50
     */
    @GetMapping("/register")
    public String register() {
        return "/register";
    }

    /**
     * TODO: 首页
     * @author wgbing
     * @date 2018/8/14 8:49
     */
    @GetMapping("/index")
    public String index() {
        return "/index";
    }

    /**
     * TODO: 主页
     * @author wgbing
     * @date 2018/8/14 8:49
     */
    @GetMapping("/main")
    public String welcome() {
        return "/main";
    }

    /**
     * TODO: 系统图标
     * @author wgbing
     * @date 2018/8/14 8:49
     */
    @GetMapping("/icons")
    public String icons(){
        return "/icons";
    }
}

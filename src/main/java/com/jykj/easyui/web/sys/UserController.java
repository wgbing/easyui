package com.jykj.easyui.web.sys;

import cn.hutool.core.util.StrUtil;
import com.jykj.easyui.common.R;
import com.jykj.easyui.service.sys.UserService;
import com.jykj.easyui.utils.IdentityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/sys/user")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * TODO: 修改密码页面
     * @author wgbing
     * @date 2018/8/14 11:40
     */
    @GetMapping("/editPwdIndex")
    public String editUserPwdIndex(Map<String,Object> map){
        String loginName = IdentityUtils.getLoginName();
        map.put("loginName",loginName);
        return "/base/user/editUserPwd";
    }

    @ResponseBody
    @PostMapping("/updateUserPwd")
    public R updateUserPwd(String oldPwd, String pwd){
        if(StrUtil.isEmpty(oldPwd) || StrUtil.isEmpty(pwd)){
            return R.failure("参数校验失败，请刷新页面，重新提交！");
        }
        return this.userService.updateUserPwd(oldPwd,pwd);
    }

}

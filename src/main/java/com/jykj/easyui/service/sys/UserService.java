package com.jykj.easyui.service.sys;


import com.jykj.easyui.common.R;
import com.jykj.easyui.dao.UserDao;
import com.jykj.easyui.domain.User;
import com.jykj.easyui.utils.EncryptUtil;
import com.jykj.easyui.utils.IdentityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO: 用户管理业务逻辑处理层
 * @author wgbing
 * @date 2018/8/13 13:40
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;

    public R updateUserPwd(String oldPwd, String pwd) {
        User user = this.userDao.findOne(IdentityUtils.getUser().getId());
        if(null == user) {
            return R.failure("请先登录再修改密码");
        }

        if(!EncryptUtil.match(oldPwd, user.getPassword())) {
            return R.failure("旧密码输入不正确");
        }

        user.setPassword(EncryptUtil.encode(pwd));
        userDao.save(user);

        return R.success("修改密码成功！");
    }
}

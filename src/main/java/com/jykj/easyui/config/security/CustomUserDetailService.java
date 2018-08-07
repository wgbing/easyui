package com.jykj.easyui.config.security;

import com.jykj.easyui.dao.PermissionDao;
import com.jykj.easyui.dao.UserDao;
import com.jykj.easyui.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 功能描述：获取登录账号的权限信息
 */
@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PermissionDao permissionDao;

    @Value("${admin.username}")
    private String username;

    /**
     * 功能描述：封装用户的权限信息为spring security的user
     **/
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userdetail = null;
        User user = userDao.findUserByUsername(username);
        //密码设置为null
        if(null != user){
            String password = user.getPassword();
            user.setPassword(null);
            //取得用户的权限
            Collection<GrantedAuthority> grantedAuths = obtionGrantedAuthorities(user);
            // 封装成spring security的user
            userdetail = new CustomUserDetail(
                    user.getLoginName(),
                    password,
                    user.getEnable(),  //账号状态  0 表示停用  1表示启用
                    true,
                    true,
                    true,
                    grantedAuths,	//用户的权限
                    user,
                    null
            );
        }
        return userdetail;
    }

    /**
     * 功能描述：获取登录账号的权限信息
     **/
    private Set<GrantedAuthority> obtionGrantedAuthorities(User user) {
        List<String> permissionKey=null;
        if(username.equals(user.getLoginName().trim()))
        {
            permissionKey=permissionDao.findAllPermissionKeys();
        }
        else
        {
            permissionKey=permissionDao.findPermissionKeysByUserId(user.getId());
        }

        Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
        if(permissionKey!=null&&permissionKey.size()>0) {
            for (String key : permissionKey) {
                // TODO:ZZQ 用户可以访问的资源名称（或者说用户所拥有的权限） 注意：必须"ROLE_"开头
                authSet.add(new SimpleGrantedAuthority("ROLE_" + key));
            }
        }
        return authSet;
    }

    /**
     * 更新登录信息
     * @param username
     * @param ip
     */
    public void updateLoginInfo(String username, String ip) {
        User u = userDao.findUserByUsername(username);
        if(null != u) {
            u.setLastLoginTime(new Date());
            u.setLastLoginIp(ip);
            userDao.save(u);
        }
    }
}
